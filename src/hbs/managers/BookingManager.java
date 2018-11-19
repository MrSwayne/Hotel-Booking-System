package hbs.managers;


import hbs.views.BookingView;
import hbs.models.BookingModel;
//import view and model.
public class BookingManager{

	private BookingView view;
	private BookingModel model;

	public BookingManager(BookingView view)
	{
	    model = new BookingModel();
	    this.view = view;
	}

	public void makeBooking(String fName,String lName,String date_in,String date_out,String roomsBooked,String type) 
	{
	    model.setDateIn("01/06/2019");
	    model.setDateOut("21/06/2019");
	   // model.setAvailability(true);
	   // model.setRoomNumbers(10);
	   // model.setType("DoubleRoom");
	    if(date_in != null && date_out != null) {
		if(dateAvailble(date_in,date_out))
		{ /*
		   if(model.getAvailability()) {
		       if(type.equals(model.getType()))
		       {
			   System.out.println("JAKIE TO JEST GOWNO");
			   //Other methods to call to do etc.
		       }
		   }*/
		}
	    }
	}
	
	public boolean dateAvailble(String dIn,String dOut)
	{
	    if(dIn.equals(model.getDateIn()) && dOut.equals(model.getDateOut())) {
		return true;
	    }else
		return false;
	}
}
