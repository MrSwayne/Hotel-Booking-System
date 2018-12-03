package hbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import hbs.database.Query;
import javax.swing.JTextField;

import hbs.managers.LoginManager;
import hbs.managers.SelectBookingManager;
import hbs.views.HintTextField;
import hbs.views.LoginView;
import hbs.views.MainMenuView;
import hbs.views.SelectBookingView;
import hbs.views.View;

public class SelectBookingController extends Controller {
	
	Query query = new Query();
	
	@Override
	public void addObserver(View view) {
		this.observers.add(view);
		SelectBookingView bookingView = (SelectBookingView) view; 
		getData(bookingView);
		
		bookingView.addSearchListener(new SearchBookingListener(bookingView));
		
	}

	@Override
	public void removeObserver(View view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		for(int i = 0;i < this.observers.size();i++) {
			SelectBookingView view = (SelectBookingView)(observers.get(i));
			
			if(this.query != null)
				view.updateTable(this.query);
		}
		
	}
	
	private void getData(SelectBookingView view) {
		System.out.println("Searching");
		ArrayList<HintTextField> fields = view.getFields();
		if(fields != null && !fields.isEmpty()) { 
			SelectBookingManager manager = new SelectBookingManager();
			
			query = manager.search(fields);
			System.out.println(query.toString());
			notifyObservers();
		} else {
			System.out.println("Nothing to show");
		}		
	}

class SearchBookingListener implements ActionListener{
		
		private SelectBookingView view;
		
		public SearchBookingListener(SelectBookingView view) {
			this.view = view;
		}
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	try {
	    		getData(view);
	    		
	    	} catch(Exception ex) {
	    		ex.printStackTrace();
	    	}
		
	    }
	    
	}
}
