package hbs.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import hbs.managers.BookingManager;
import hbs.views.BookingView;
import hbs.views.MainMenuView;
import hbs.views.View;
//import view and model.
public class BookingController extends Controller {
	public BookingController()
	{
	}
	@Override
	public void addObserver(View view)
	{
	    observers.add(view);
	    BookingView bookingView = (BookingView) view;
	    BookingListener listener = new BookingListener(bookingView); 
	    bookingView.addBookingListener(listener);
	}
	
	@Override
	public void removeObserver(View view) {
	    observers.remove(view);
	}
	
	class BookingListener implements ActionListener{
		
		private BookingView view;
		
		public BookingListener(BookingView view) {
			this.view = view;
		}
	    
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		try {
			BookingManager bookingManager = new BookingManager();
			BookingController bookingC = new BookingController();
			if(bookingManager.checkBooking(view.getFirstName(),view.getLastName(),view.getDateIn(),view.getDateOut(),
				view.getRoomAmount(),view.getRoomType()))
			{
			  bookingC.notifyObservers();
			}
		    
		}catch(Exception e) {
		    
		}
		
	    }
	    
	}

	@Override
	public void notifyObservers() {
	    MainMenuView menu = new MainMenuView();
	    menu.MainMenuView();
	}
}
