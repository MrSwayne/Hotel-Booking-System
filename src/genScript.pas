(*
  Copyright (C) 2007 by Seth Grover.  All rights reserved.

  This file is part of the Spawner Data Generator.

  The Spawner Data Generator is free software; you can
  redistribute it and/or modify it under the terms of the GNU General
  Public License (GPL) as published by the Free Software Foundation; either
  version 2 of the License, or (at your option) any later version.

  The Spawner Data Generator is distributed in the hope
  that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
  warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with the Spawner Data Generator; if not, write to
  the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
  02110-1301  USA
*)
procedure TMainForm.MemoMenuItemClick(Sender: TObject);
var
  TheMemo : TSynMemo;
  TheItem : TMenuItem;
begin
  try
    TheMemo := nil;
    TheItem := nil;
    with Sender as TMenuItem do begin    { TMenuItem that clicked }
      TheItem := (Sender as TMenuItem);
      with Parent as TMenuItem do begin   { Items property of the TPopupMenu }
        with Owner as TPopupMenu do begin   { TPopupMenu }
          if PopupComponent is TSynMemo then begin
            TheMemo := (PopupComponent as TSynMemo);
          end;
        end;
      end;
    end;
    if Assigned(TheMemo) then begin
      if (TheItem = ClearMemoMenuItem) then begin
        TheMemo.Lines.Clear;
      end else if (TheItem = SelectAllMenuItem) then begin
        TheMemo.SelectAll;
      end else if (TheItem = CopyMenuItem) then begin
        ClipBoard.AsText := TheMemo.SelText;
      end else if (TheItem = CutMenuItem) then begin
        ClipBoard.AsText := TheMemo.SelText;
        // not done yet
      end else if (TheItem = PasteMenuItem) then begin
        // not done yet
      end
    end;
  except
  end;
end;

procedure TMainForm.ExitButtonClick(Sender: TObject);
begin
  Close;
end;

procedure TMainForm.FieldAddButtonClick(Sender: TObject);
var
  i : integer;
  theEvent : TNotifyEvent;
begin
  FCancelled := true;
  { set the field options to default and make a new name }
  theEvent := FieldListBox.OnClick;
  try
    FieldListBox.OnClick := nil;
    for i := 0 to FieldListBox.Items.Count-1 do begin
      FieldListBox.Selected[i] := false;
    end;
  finally
    FieldListBox.OnClick := theEvent;
  end;
  
  FieldNameEdit.Text := 'New Field';
  FieldTypeComboBox.ItemIndex := 0;
  FieldTypeComboBoxSelect(FieldTypeComboBox);
  FieldSubTypeComboBoxSelect(FieldSubTypeComboBox);
end;

procedure TMainForm.FieldDownButtonClick(Sender: TObject);
var
  tmpString : string;
  tmpObject : TObject;
begin
  { move the selected field down in order in the list }
  if (FieldListBox.ItemIndex > -1) and
     (FieldListBox.ItemIndex < FieldListBox.Items.Count-1) then begin
    tmpString := FieldListBox.Items.Strings[FieldListBox.ItemIndex];
    tmpObject := FieldListBox.Items.Objects[FieldListBox.ItemIndex];
    FieldListBox.Items.Strings[FieldListBox.ItemIndex] := FieldListBox.Items.Strings[FieldListBox.ItemIndex+1];
    FieldListBox.Items.Objects[FieldListBox.ItemIndex] := FieldListBox.Items.Objects[FieldListBox.ItemIndex+1];
    FieldListBox.Items.Strings[FieldListBox.ItemIndex+1] := tmpString;
    FieldListBox.Items.Objects[FieldListBox.ItemIndex+1] := tmpObject;
    FieldListBox.ItemIndex := FieldListBox.ItemIndex+1;
  end;
end;

procedure TMainForm.ChangeComboBoxes(const theType : string;
                                     const theSubType : string);
begin
  if (theType <> '') then begin
    FieldTypeComboBox.ItemIndex := FieldTypeComboBox.Items.IndexOf(theType);
    FieldTypeComboBoxSelect(FieldTypeComboBox);
    if (theSubType <> '') then begin
      FieldSubTypeComboBox.ItemIndex := FieldSubTypeComboBox.Items.IndexOf(theSubType);
      FieldSubTypeComboBoxSelect(FieldSubTypeComboBox);
    end;
  end else begin
    FieldTypeComboBox.ItemIndex := -1;
  end;
end;

procedure TMainForm.FieldListBoxClick(Sender: TObject);
var
  theObject : TObject;
  theField : TField;
begin
  if (FieldListBox.ItemIndex = -1) then exit;

  theObject := FieldListBox.Items.Objects[FieldListBox.ItemIndex];
  theField := (TField(theObject));

  if Assigned(theField) then begin
    // change the combo boxes and open the right notebook page
    ChangeComboBoxes(theField.ItemType, theField.ItemSubType);

    FieldNameEdit.Text := theField.Name;
    
    // set up whatever controls need to be set up
    if (theField is TSetField) then begin
      FieldOptionSetListBox.Items.Clear;
      FieldOptionsSetFileEdit.Clear;
      if ((theField as TSetField).FileName = '') then begin
        FieldOptionSetListBox.Items.Text := (theField as TSetField).GetSetString;
      end else begin
        FieldOptionsSetFileEdit.FileName := (theField as TSetField).FileName;
      end;
      FieldOptionSetCorrelateCheckbox.Checked := (theField as TSetField).GetCorrelationOption;
      FieldOptionSetNumericalCheckbox.Checked := (theField as TSetField).GetNumericalOption;
      FieldOptionSetFileCorrelateCheckbox.Checked := (theField as TSetField).GetCorrelationOption;
      FieldOptionSetFileNumericalCheckbox.Checked := (theField as TSetField).GetNumericalOption;
    end else if (theField is TIntegerRangeField) then begin
      FieldOptionIntegerRangeLowSpinEdit.Value := (theField as TIntegerRangeField).LowVal;
      FieldOptionIntegerRangeHighSpinEdit.Value := (theField as TIntegerRangeField).HighVal;
    end else if (theField is TRealRangeField) then begin
      FieldOptionRealRangeLowSpinEdit.Value := (theField as TRealRangeField).LowVal;
      FieldOptionRealRangeHighSpinEdit.Value := (theField as TRealRangeField).HighVal;
      FieldOptionRealRangeDecimalSpinEdit.Value := (theField as TRealRangeField).DecimalPlaces;
    end else if (theField is TSequenceField) then begin
      FieldOptionSequenceStartSpinEdit.Value := (theField as TSequenceField).Start;
      FieldOptionSequenceRepetitionSpinEdit.Value := (theField as TSequenceField).RepetitionValue;
      FieldOptionSequenceStrideSpinEdit.Value := (theField as TSequenceField).Stride;
      FieldOptionSequenceDupRestartRadioGroup.ItemIndex := (theField as TSequenceField).RepetitionMode;
    end else if (theField is TStateField) then begin
      if (theField as TStateField).Full then begin
        FieldOptionStateFullRadioButton.Checked := true;
      end else begin
        FieldOptionStateAbbrRadioButton.Checked := true;
      end;
    end else if (theField is TDateTimeRangeField) then begin
      if (theField as TDateTimeRangeField).DisplayUnix then begin
        FieldOptionTimeUnixRadioButton.Checked := true;
      end else begin
        FieldOptionTimeFormatRadioButton.Checked := true;
      end;
      FieldOptionDateFormatEdit.Text := (theField as TDateTimeRangeField).DateFormat;
      FieldOptionTimeFormatEdit.Text := (theField as TDateTimeRangeField).TimeFormat;
      if (FieldOptionDateFormatEdit.Text = '') then FieldOptionDateFormatEdit.Text := DefaultFormatSettings.ShortDateFormat;
      if (FieldOptionTimeFormatEdit.Text = '') then FieldOptionTimeFormatEdit.Text := DefaultFormatSettings.LongTimeFormat;
      if ((theField as TDateTimeRangeField).TimeType = tsNow) then
        FieldOptionStepRadioGroup.ItemIndex := 0
      else if ((theField as TDateTimeRangeField).TimeType = tsIncrementing) then
        FieldOptionStepRadioGroup.ItemIndex := 1
      else if ((theField as TDateTimeRangeField).TimeType = tsDecrementing) then
        FieldOptionStepRadioGroup.ItemIndex := 2
      else
        FieldOptionStepRadioGroup.ItemIndex := 3;
      if (FieldOptionStepRadioGroup.ItemIndex = 0) then begin
        FieldOptionDateLowCalendar.Date := now-7;
        FieldOptionDateHighCalendar.Date := now;
        FieldOptionTimeLowEdit.Text := FormatDateTime(DefaultFormatSettings.LongTimeFormat, now);
        FieldOptionTimeHighEdit.Text := FormatDateTime(DefaultFormatSettings.LongTimeFormat, now);
      end else begin
        FieldOptionDateLowCalendar.Date := (theField as TDateTimeRangeField).LowVal;
        FieldOptionDateHighCalendar.Date := (theField as TDateTimeRangeField).HighVal;
        FieldOptionTimeLowEdit.Text := FormatDateTime(DefaultFormatSettings.LongTimeFormat, (theField as TDateTimeRangeField).LowVal);
        FieldOptionTimeHighEdit.Text := FormatDateTime(DefaultFormatSettings.LongTimeFormat, (theField as TDateTimeRangeField).HighVal);
      end;
    end else if (theField is TWordsField) then begin
      FieldOptionFixedWordSpinEdit.Value := (theField as TWordsField).LowVal;
      FieldOptionRandomWordLowSpinEdit.Value := (theField as TWordsField).LowVal;
      FieldOptionRandomWordHighSpinEdit.Value := (theField as TWordsField).HighVal;
    end else if (theField is TStringField) then begin
      FieldOptionFixedStringSpinEdit.Value := (theField as TStringField).LowVal;
      FieldOptionRandomStringLowSpinEdit.Value := (theField as TStringField).LowVal;
      FieldOptionRandomStringHighSpinEdit.Value := (theField as TStringField).HighVal;
      FieldOptionFixedStringAllowedCheckGroup.Checked[STRING_ALPHA] := (theField as TStringField).AllowAlpha;
      FieldOptionFixedStringAllowedCheckGroup.Checked[STRING_NUMBER] := (theField as TStringField).AllowNumber;
      FieldOptionFixedStringAllowedCheckGroup.Checked[STRING_SPACE] := (theField as TStringField).AllowSpace;
      FieldOptionFixedStringAllowedCheckGroup.Checked[STRING_OTHER] := (theField as TStringField).AllowOther;
      FieldOptionRandomStringAllowedCheckGroup.Checked[STRING_ALPHA] := (theField as TStringField).AllowAlpha;
      FieldOptionRandomStringAllowedCheckGroup.Checked[STRING_NUMBER] := (theField as TStringField).AllowNumber;
      FieldOptionRandomStringAllowedCheckGroup.Checked[STRING_SPACE] := (theField as TStringField).AllowSpace;
      FieldOptionRandomStringAllowedCheckGroup.Checked[STRING_OTHER] := (theField as TStringField).AllowOther;
    end else if (theField is TNameField) then begin
      FieldOptionNameSexCheckGroup.Checked[SEX_FEMALE] := (theField as TNameField).Female;
      FieldOptionNameSexCheckGroup.Checked[SEX_MALE] := (theField as TNameField).Male;
    end else if (theField is TMaskField) then begin
      FieldOptionsMaskEdit.Text := (theField as TMaskField).Mask;
    end;
  end;
end;

procedure TMainForm.FieldListBoxDblClick(Sender: TObject);
var
  theObject : TObject;
  theField : TField;
begin
  if (FieldListBox.ItemIndex > -1) then begin
    theObject := FieldListBox.Items.Objects[FieldListBox.ItemIndex];
    theField := (TField(theObject));
    if (theField is TSequenceField) then begin
      SetStatus(theField.Name);
      exit; // sequence has state
    end;
    if Assigned(theField) then begin
      SetStatus(theField.Name + ' data example: "' + theField.GetField + '"');
    end else begin
      ShowString('Selected field ' +
                 FieldListBox.Items.Strings[FieldListBox.ItemIndex] +
                 ' was not created correctly!');
    end;
  end;
end;

procedure TMainForm.FieldOptionSequenceDupRestartRadioGroupClick(Sender: TObject
  );
begin

end;

procedure TMainForm.FieldOptionSequenceDupRestartRadioGroupSelectionChanged(
  Sender: TObject);
begin
   FieldOptionSequenceRepetitionTimesLabel.Visible := FieldOptionSequenceDupRestartRadioGroup.Items[FieldOptionSequenceDupRestartRadioGroup.ItemIndex] = 'Duplicate';
end;

procedure TMainForm.FieldOptionSetAddItemButtonClick(Sender: TObject);
var
  newString : string;
begin
  { add an item to the set list }
  newString :=   InputBox ('New Set Value',
                           'Enter a new value to be included in the set:',
                           '');
  if (trim(newString) <> '') then  FieldOptionSetListBox.Items.Add(newString);
end;

procedure TMainForm.FieldOptionSetElementDownButtonClick(Sender: TObject);
var
  tmpString : string;
  tmpObject : TObject;
begin
  { move the selected element down in order in the list }
  if (FieldOptionSetListBox.ItemIndex > -1) and
     (FieldOptionSetListBox.ItemIndex < FieldOptionSetListBox.Items.Count-1) then begin
    tmpString := FieldOptionSetListBox.Items.Strings[FieldOptionSetListBox.ItemIndex];
    tmpObject := FieldOptionSetListBox.Items.Objects[FieldOptionSetListBox.ItemIndex];
    FieldOptionSetListBox.Items.Strings[FieldOptionSetListBox.ItemIndex] := FieldOptionSetListBox.Items.Strings[FieldOptionSetListBox.ItemIndex+1];
    FieldOptionSetListBox.Items.Objects[FieldOptionSetListBox.ItemIndex] := FieldOptionSetListBox.Items.Objects[FieldOptionSetListBox.ItemIndex+1];
    FieldOptionSetListBox.Items.Strings[FieldOptionSetListBox.ItemIndex+1] := tmpString;
    FieldOptionSetListBox.Items.Objects[FieldOptionSetListBox.ItemIndex+1] := tmpObject;
    FieldOptionSetListBox.ItemIndex := FieldOptionSetListBox.ItemIndex+1;
  end;
end;

procedure TMainForm.FieldOptionSetElementUpButtonClick(Sender: TObject);
var
  tmpString : string;
  tmpObject : TObject;
begin
   { move the selected element down in order in the list }
  if (FieldOptionSetListBox.ItemIndex > 0) then begin
    tmpString := FieldOptionSetListBox.Items.Strings[FieldOptionSetListBox.ItemIndex];
    tmpObject := FieldOptionSetListBox.Items.Objects[FieldOptionSetListBox.ItemIndex];
    FieldOptionSetListBox.Items.Strings[FieldOptionSetListBox.ItemIndex] := FieldOptionSetListBox.Items.Strings[FieldOptionSetListBox.ItemIndex-1];
    FieldOptionSetListBox.Items.Objects[FieldOptionSetListBox.ItemIndex] := FieldOptionSetListBox.Items.Objects[FieldOptionSetListBox.ItemIndex-1];
    FieldOptionSetListBox.Items.Strings[FieldOptionSetListBox.ItemIndex-1] := tmpString;
    FieldOptionSetListBox.Items.Objects[FieldOptionSetListBox.ItemIndex-1] := tmpObject;
    FieldOptionSetListBox.ItemIndex := FieldOptionSetListBox.ItemIndex-1;
  end;
end;

procedure TMainForm.FieldOptionSetRemoveItemButtonClick(Sender: TObject);
begin
  { remove an item from the set list }
  if (FieldOptionSetListBox.ItemIndex >= 0) then begin
    FieldOptionSetListBox.Items.Delete(FieldOptionSetListBox.ItemIndex);
  end;
end;

procedure TMainForm.FieldOptionsSequencePageBeforeShow(ASender: TObject;
  ANewPage: TPage; ANewIndex: Integer);
begin

end;

procedure TMainForm.FieldOptionTimeUnixRadioButtonChange(Sender : TObject);
begin
  FieldOptionTimeFormatEdit.Enabled := FieldOptionTimeFormatRadioButton.Checked;
  FieldOptionDateFormatEdit.Enabled := FieldOptionTimeFormatRadioButton.Checked;
end;

procedure TMainForm.FieldRemoveButtonClick(Sender: TObject);
var
  deleteReply : integer;
  theObject : TObject;
  theField : TField;
  needPrompt : boolean;
begin
  needPrompt := true;
  if (Sender is TMenuItem) and ((Sender as TMenuItem) = ClearAllMenuItem) then needPrompt := false;
  { delete the selected field from the list }
  if (FieldListBox.ItemIndex > -1) then begin
    if (needPrompt) and (FieldListBox.Count > 0) then begin
      deleteReply :=  Application.MessageBox (PChar('Remove field ' +  FieldListBox.Items.Strings[FieldListBox.ItemIndex] + '?'),
                                                 'Remove?', MB_ICONQUESTION + MB_YESNO);
    end else begin
      deleteReply := IDYES;
    end;
    if (deleteReply = IDYES) then begin
      theObject := FieldListBox.Items.Objects[FieldListBox.ItemIndex];
      theField := (TField(theObject));
      ShowString('Deleting field ' + theField.Name + ' of type/subtype ' +
                 theField.ItemType + ' ' + theField.ItemSubType);
      if Assigned(theField) then FreeAndNil(theField);
      FieldListBox.Items.Delete(FieldListBox.ItemIndex);
    end else begin
      exit;
    end;
  end;
end;



procedure TMainForm.FieldSubTypeComboBoxSelect(Sender: TObject);
var
  i : integer;
begin
  if (FieldSubTypeComboBox.Text = SUBTYPE_SET_FIXED) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_SET;
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_SET_FILE) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_FROMFILE;
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_INTEGERRANGE_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_INT;
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_REALRANGE_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_REAL;
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_SEQUENCE_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_INT_SEQ;
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_STATE_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_STATE;
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_DATE_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_TIME;
    FieldOptionDateLowCalendar.Enabled := true;
    FieldOptionDateHighCalendar.Enabled := true;
    FieldOptionDateFormatEdit.Enabled := true;
    FieldOptionDateLowCalendar.Date := now-7;
    FieldOptionDateHighCalendar.Date := now;
    FieldOptionTimeLowEdit.Enabled := false;
    FieldOptionTimeFormatEdit.Enabled := false;
    FieldOptionTimeHighEdit.Enabled := false;
    FieldOptionTimeLowEdit.Text := '';
    FieldOptionTimeHighEdit.Text := '';
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_TIME_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_TIME;
    FieldOptionDateLowCalendar.Enabled := false;
    FieldOptionDateHighCalendar.Enabled := false;
    FieldOptionDateFormatEdit.Enabled := false;
    FieldOptionDateLowCalendar.Date := now-7;
    FieldOptionDateHighCalendar.Date := now;
    FieldOptionTimeLowEdit.Enabled := true;
    FieldOptionTimeFormatEdit.Enabled := true;
    FieldOptionTimeHighEdit.Enabled := true;
    FieldOptionTimeLowEdit.Text := FormatDateTime(DefaultFormatSettings.LongTimeFormat, 0.0);
    FieldOptionTimeHighEdit.Text := FormatDateTime(DefaultFormatSettings.LongTimeFormat, now);
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_DATETIME_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_TIME;
    FieldOptionDateLowCalendar.Enabled := true;
    FieldOptionDateHighCalendar.Enabled := true;
    FieldOptionDateFormatEdit.Enabled := true;
    FieldOptionDateLowCalendar.Date := now-7;
    FieldOptionDateHighCalendar.Date := now;
    FieldOptionTimeLowEdit.Enabled := true;
    FieldOptionTimeFormatEdit.Enabled := true;
    FieldOptionTimeHighEdit.Enabled := true;
    FieldOptionTimeLowEdit.Text := FormatDateTime(DefaultFormatSettings.LongTimeFormat, 0.0);
    FieldOptionTimeHighEdit.Text := FormatDateTime(DefaultFormatSettings.LongTimeFormat, now);
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_FIXEDWORDS_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_WORDS;
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_RANDOMWORDS_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_WORDS_RANGE;
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_FIXEDALPHA_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_CHARS;
    for i := 0 to FieldOptionFixedStringAllowedCheckGroup.Items.Count-1 do begin
      FieldOptionFixedStringAllowedCheckGroup.Checked[i] := true;
    end;
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_RANDOMALPHA_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_CHARS_RANGE;
    for i := 0 to FieldOptionRandomStringAllowedCheckGroup.Items.Count-1 do begin
      FieldOptionRandomStringAllowedCheckGroup.Checked[i] := true;
    end;
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_MASK_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_MASK;
    FieldOptionsMaskEdit.Text := '';
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_NAME_NAME) or
              (FieldSubTypeComboBox.Text = SUBTYPE_FIRSTNAME_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_NAME;
    for i := 0 to FieldOptionNameSexCheckGroup.Items.Count-1 do begin
      FieldOptionNameSexCheckGroup.Checked[i] := true;
    end;
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_IP_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_IP4;
  end else if (FieldSubTypeComboBox.Text = SUBTYPE_IPV6_NAME) then begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_IP6;
  end else begin
    FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_NONE;
  end;
end;

procedure TMainForm.FieldTypeComboBoxSelect(Sender: TObject);
begin
  FieldSubTypeComboBox.Clear;
  FieldOptionsNotebook.PageIndex := FIELD_OPTIONS_PAGE_IDX_NONE;
  if (FieldTypeComboBox.Text = TYPE_RANGE_NAME) then begin
    FieldSubTypeComboBox.AddItem(SUBTYPE_INTEGERRANGE_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_REALRANGE_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_SEQUENCE_NAME, nil);
  end else if (FieldTypeComboBox.Text = TYPE_TIME_NAME) then begin
    FieldSubTypeComboBox.AddItem(SUBTYPE_DATE_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_TIME_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_DATETIME_NAME, nil);
  end else if (FieldTypeComboBox.Text = TYPE_HUMAN_NAME) then begin
    FieldSubTypeComboBox.AddItem(SUBTYPE_NAME_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_FIRSTNAME_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_LASTNAME_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_EMAIL_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_PHONE_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_ADDRESS_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_CITY_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_STATE_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_ZIP_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_POSTCODE_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_COUNTRY_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_SS_NAME, nil);
  end else if (FieldTypeComboBox.Text = TYPE_TEXT_NAME) then begin
    FieldSubTypeComboBox.AddItem(SUBTYPE_FIXEDWORDS_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_RANDOMWORDS_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_FIXEDALPHA_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_RANDOMALPHA_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_MASK_NAME, nil);
  end else if (FieldTypeComboBox.Text = TYPE_SET_NAME) then begin
    FieldSubTypeComboBox.AddItem(SUBTYPE_SET_FIXED, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_SET_FILE, nil);
  end else if (FieldTypeComboBox.Text = TYPE_NET_NAME) then begin
    FieldSubTypeComboBox.AddItem(SUBTYPE_IP_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_IPV6_NAME, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_MAC_NAME, nil);
  end else if (FieldTypeComboBox.Text = TYPE_GUID_NAME) then begin
    FieldSubTypeComboBox.AddItem(SUBTYPE_GUID_DASHES, nil);
    FieldSubTypeComboBox.AddItem(SUBTYPE_GUID_NODASHES, nil);
  end;
  if (FieldSubTypeComboBox.Items.Count > 0) then FieldSubTypeComboBox.ItemIndex := 0;
  FieldSubTypeComboBoxSelect(FieldSubTypeComboBox);
end;

procedure TMainForm.FieldUpButtonClick(Sender: TObject);
var
  tmpString : string;
  tmpObject : TObject;
begin
  { move the selected field up in order in the list }
  if (FieldListBox.ItemIndex > 0) then begin
    tmpString := FieldListBox.Items.Strings[FieldListBox.ItemIndex];
    tmpObject := FieldListBox.Items.Objects[FieldListBox.ItemIndex];
    FieldListBox.Items.Strings[FieldListBox.ItemIndex] := FieldListBox.Items.Strings[FieldListBox.ItemIndex-1];
    FieldListBox.Items.Objects[FieldListBox.ItemIndex] := FieldListBox.Items.Objects[FieldListBox.ItemIndex-1];
    FieldListBox.Items.Strings[FieldListBox.ItemIndex-1] := tmpString;
    FieldListBox.Items.Objects[FieldListBox.ItemIndex-1] := tmpObject;
    FieldListBox.ItemIndex := FieldListBox.ItemIndex-1;
  end;
end;

procedure TMainForm.FormCloseQuery(Sender: TObject; var CanClose: boolean);
var
  reply, boxStyle: integer;
begin
  CanClose := false;
  with Application do begin
    boxStyle :=  MB_ICONQUESTION + MB_YESNO;
    reply :=  MessageBox ('Are you sure you want to exit?', 'Exit?', boxStyle);
  end;
  if reply = IDYES then CanClose := true;
end;