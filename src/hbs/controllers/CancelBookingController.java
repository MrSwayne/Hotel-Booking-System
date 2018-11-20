package hbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hbs.managers.CancelBookingManager;
import hbs.views.CancelBookingView;
import hbs.views.View;

public class CancelBookingController extends Controller {

    public CancelBookingController() {
	
    }
    
    @Override
    public void addObserver(View view) {
	observers.add(view);
	CancelBookingView cancelView = (CancelBookingView) view;
	CancelListener listener = new CancelListener(cancelView); 
	cancelView.addCancelListener(listener);
	
    }

    @Override
    public void removeObserver(View view) {
	observers.remove(view);
    }
    
    class CancelListener implements ActionListener{
	
	private CancelBookingView view;
	
	public CancelListener(CancelBookingView view) {
		this.view = view;
	}
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
	try {
		CancelBookingManager cancelManager = new CancelBookingManager();
		cancelManager.cancelBooking(view.getBookingID(),view.getPassword());
		
	    
	}catch(Exception e) {
	    
	}
	
    }
    
}

    @Override
    public void notifyObservers() {
	// TODO Auto-generated method stub
	
    }

}
