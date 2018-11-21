package hbs.managers;

import hbs.controllers.CancelBookingController;
import hbs.models.BookingModel;
import hbs.models.LoginModel;

public class CancelBookingManager {
    private BookingModel bookingM = new BookingModel();
    private LoginModel loginM = new LoginModel();
    private CancelBookingController cancelC = new CancelBookingController();
    public CancelBookingManager()
   	{
   	}

    public void cancelBooking(String bookingID, String password) {
    	loginM.setPassword("easy");
    	bookingM.setBID(304);
	if(bookingID != null && password != null)
	{
	    if(bookingID.matches("[0-9]+"))
	    {
		int bID = Integer.parseInt(bookingID);
		if(bID == bookingM.getBID() && password.equals(loginM.getPassword())) {
		    //remove booking with that ID on it.
		    System.out.println("You removed booking with ID" + bID);
		    cancelC.notifyObservers();
		    
		}
	    }
	}
	
    }
}
