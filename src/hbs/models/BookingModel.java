package hbs.models;

public class BookingModel extends Model
{
	private int gID, rID, bID,nights; 
	private String date_in, date_out;
	
	public BookingModel()
	{
		
	}
	
	public int getGID()
	{
		return gID;
	}
	
	public int getRID()
	{
		return rID;
	}
	
	public int getBID()
	{
		return bID;
	}
	
	public void setBID(int bID)
	{
	    this.bID= bID;
	}

	public void setDateIn(String date)
	{
		this.date_in = date;
	}
	
	public String getDateIn()
	{
		return date_in;
	}
	
	public void setDateOut(String date)
	{
		this.date_out = date;
	}
	
	public String getDateOut()
	{
		return date_out;
	}
	
	public int getAmountOfNights()
	{
	    return nights;
	}
	
	public void setAmountOfNights(int nights)
	{
	    this.nights=nights;
	}

	//Method to get all the information for booking in db
	//public void getBookings()
}
