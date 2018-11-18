package hbs.models;

public class BookingModel
{
	private int gID, rID, bID; 
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
}
