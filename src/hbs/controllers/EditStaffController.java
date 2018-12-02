package hbs.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hbs.managers.EditStaffManager;
import hbs.views.EditStaffView;
import hbs.views.MainMenuView;
import hbs.views.View;
//import view and model.
public class EditStaffController extends Controller {
	public EditStaffController()
	{
	}
	@Override
	public void addObserver(View view)
	{
	    observers.add(view);
	    EditStaffView editStaffView = (EditStaffView) view;
	    EditStaffListener listener = new EditStaffListener(editStaffView); 
	    editStaffView.addEditStaffListener(listener);
	}
	
	@Override
	public void removeObserver(View view) {
	    observers.remove(view);
	}
	
	class EditStaffListener implements ActionListener{
		
		private EditStaffView view;
		
		public EditStaffListener(EditStaffView view) {
			this.view = view;
		}
	    
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
			try {
				EditStaffManager editStaffManager = new EditStaffManager();
				editStaffManager.checkInfo(view.getUserID(),view.getFirstName(),view.getLastName(),view.getPassword(),view.getWages());	    
			} catch(Exception e) {
			    
			}
	    }
	    
	}

	@Override
	public void notifyObservers() {
	    MainMenuView menu = new MainMenuView();
	    menu.MainMenuView();
	}
}
