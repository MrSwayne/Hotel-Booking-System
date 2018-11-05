package Models;

public class BookingModel
{
	private int gID, rID, bID, 
	private date date_in, date_out;
	
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
	
	public void setDateIn(date date)
	{
		this.date_in = date;
	}
	
	public date getDateIn()
	{
		return date_in;
	}
	
	public void setDateOut(date date)
	{
		this.date_out = date;
	}
	
	public date getDateOut()
	{
		return date_out;
	}
}
