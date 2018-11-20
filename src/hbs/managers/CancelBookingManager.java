package hbs.managers;

import hbs.models.BookingModel;
import hbs.models.LoginModel;

public class CancelBookingManager {
    private BookingModel bookingM = new BookingModel();
    private LoginModel loginM = new LoginModel();
    public CancelBookingManager()
   	{
   	}

    public void cancelBooking(String bookingID, String password) {
	if(bookingID != null && password != null)
	{
	    if(bookingID.matches("[0-9]+"))
	    {
		int bID = Integer.parseInt(bookingID);
		if(bID == bookingM.getBID() && password.equals(loginM.getPassword())) {
		    //remove booking with that ID on it.
		    System.out.println("You removed booking with ID" + bID);
		}
	    }
	}
	
    }
}
