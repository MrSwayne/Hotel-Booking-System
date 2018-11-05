package Models;

public class RoomModel
{
	private int roomNo, hID, rID;
	private String type;
	private boolean available = true;
	private double price;
	
	public int getHID()
	{
		return hID;
	}
	
	public int getRID()
	{
		return rID;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getType()
	{
		return type;
	}
	
	public int getRoomNo()
	{
		return roomNo;
	}
	
	public void setAvailability(boolean available)
	{
		this.available = available;
	}
	
	public boolean getAvailability()
	{
		return boolean;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public double getPrice()
	{
		return price;
	}
}