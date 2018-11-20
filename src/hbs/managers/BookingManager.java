package hbs.managers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import hbs.models.BookingModel;
import hbs.models.GuestModel;
import hbs.models.RoomModel;
//import view and model.
public class BookingManager{
    private GuestModel guestM = new GuestModel();
    private RoomModel roomM = new RoomModel();
    private BookingModel bookingM = new BookingModel();
    final static String dateFormat = "dd/MM/yy";
    
    public BookingManager()
	{
	}
    public boolean checkBooking(String firstName, String lastName, String dateIn, String dateOut, String roomAmount,
	    String roomType) 
    {
	//hard coded at the moment -> change it later...
	guestM.setMemLev(1);
	roomM.setRoomNumbers(50);
	roomM.setType("Double");
	roomM.setPrice(60);
	roomM.setAvailability(true);
	//check if the name correspond to any in the db otherwise set everything as a new customer.
	if(dateValidation(dateIn,dateOut))
	{
	    System.out.println("Hurray,dates are valid");
	    if(roomsAvailable(roomAmount,roomType))
	    {
		bookingProgram(firstName,lastName,dateIn,dateOut,roomAmount,roomType);
		
		return true;
	    }
	}
	return false;
    }

	public boolean dateValidation(String dateIn,String dateOut)
	{
	  if(dateIn == null || dateOut == null)
	  {
	      return false;
	  }
	  
	  SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	  sdf.setLenient(false);
	  
	  try {
	      //if not valid, it will throw ParseException
	      Date date = sdf.parse(dateIn);
	      Date date2 = sdf.parse(dateOut);
	      bookingM.setDateIn(dateIn);
	      bookingM.setDateOut(dateOut);
	      long diff = date2.getTime() - date.getTime();
	      int nights = (int) (diff/ (1000*60*60*24));
	      bookingM.setAmountOfNights(nights);
	      System.out.println(date + " " + date2);
	  }catch (ParseException e) {
	      	  System.out.println("Invalid date(s)");
	      	  return false;
	  }
	  return true;
	}
	
	public boolean roomsAvailable(String roomAmount,String roomType)
	{
	    if(roomAmount != null || roomType != null){
		if(roomAmount.matches("[0-9]+"))
		{
		    int rmNumber = Integer.parseInt(roomAmount);
		    if((rmNumber <= roomM.getRoomNumbers())||roomType.equals(roomM.getType()))
		    {
			if(roomM.getAvailability())
			{
			    System.out.println("Hurray,room is available");
			    return true;
			}
		    }
		} 
	    }
	    return false; 
	}
	
	public void bookingProgram(String firstName, String lastName, String dateIn, String dateOut, String roomAmount,String roomType)
	{
	    bookingM.setBID(304);
	    guestM.setFirstName(firstName);
	    guestM.setLastName(lastName);
	    int memLev = guestM.getMemLev();
	    int rmBooked = Integer.parseInt(roomAmount);
	    double totalSpent;
	    double roomCost = roomM.getPrice();
	    int nights = bookingM.getAmountOfNights();
	    double discount;
	    if(memLev == 1)
	    {
		discount = 100;
		totalSpent = ((roomCost * nights) * rmBooked) - discount;
		guestM.setTotalSpent(totalSpent);
	    }else if(memLev == 2)
	    {
		discount = 200;
		totalSpent = ((roomCost * nights) * rmBooked) - discount;
		guestM.setTotalSpent(totalSpent);
	    }
	    else if(memLev == 3)
	    {
		discount = 300;
		totalSpent = ((roomCost * nights) * rmBooked) - discount;
		guestM.setTotalSpent(totalSpent);
	    }else
	    {
		totalSpent = ((roomCost * nights) * rmBooked);
		guestM.setTotalSpent(totalSpent);
	    }
	    System.out.println("You have booked a reservation with ID" + bookingM.getBID() + " total cost = " + guestM.getTotalSpent());
	}
}
