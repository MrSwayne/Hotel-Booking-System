package hbs.models;

public class RoomModel extends Model
{
	private int  roomNumbers,roomNo, hID, rID;
	private String type;
	private boolean available = true;
	private double price;
	
	public RoomModel() 
	{
		
	}
	
	
	public int getRoomNumbers() {
		return roomNumbers;
	}
	
	public void setRoomNumbers(int roomNumbers){
		this.roomNumbers = roomNumbers;
	}
	
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
		return available;
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