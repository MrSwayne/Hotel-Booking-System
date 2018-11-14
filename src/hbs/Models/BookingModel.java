package hbs.Models;

public class BookingModel
{
	private int gID, rID, bID; 
	private String date_in, date_out;
	
	public BookingModel()
	{
		
	}
	
	public BookingModel(int gID, String date_in, String date_out) {
		this.gID = gID;
		this.date_in = date_in;
		this.date_out = date_out;
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
