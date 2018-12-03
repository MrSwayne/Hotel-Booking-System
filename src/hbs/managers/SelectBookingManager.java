package hbs.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JTextField;

import hbs.database.DatabaseHelper;
import hbs.database.Query;
import hbs.views.HintTextField;

public class SelectBookingManager {
	
	public SelectBookingManager() {
		
	}
	
	public void selectBooking() {
		
	}

	public Query search(ArrayList<HintTextField> fields) {
		DatabaseHelper db = DatabaseHelper.getInstance();
		
		
		String sql = "SELECT * FROM BOOKINGS";
		
		boolean first = true;
		for(int i = 0;i < fields.size();i++) {
			if(fields.get(i).getText() != "") {
				if(!first) sql += " AND ";
				if(first) sql += " WHERE ";
				first = false;
				
				if(fields.get(i).getText().endsWith("id"))
					sql += fields.get(i).getHint() + " = " + fields.get(i).getText() + " ";
				else
					sql += fields.get(i).getHint() + " = '" + fields.get(i).getText() + "' ";
				
			}
		}
		
		sql += ";";
		
		System.out.println(sql);
		return db.executeQuery(sql);
	}
}
