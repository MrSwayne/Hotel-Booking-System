package hbs.models;


import hbs.database.DatabaseHelper;
import hbs.database.Query;

public class RoomModel extends Model
{
	private int amountOfRooms,roomNo, hID, rID;
	private String type;
	private boolean available = true;
	private double price;
	
	public RoomModel() 
	{
		
	}
	
	public int getAmountOfRooms() {
		return amountOfRooms;
	}
	
	public void setAmountOfRooms(int amountOfRooms){
		this.amountOfRooms = amountOfRooms;
	}
	
	
	public int getRoomNumber() {
		return roomNo;
	}
	
	public void setRoomNumber(int roomNo){
		this.roomNo = roomNo;
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
	
	public boolean checkRoomNo()
	{
		DatabaseHelper db = DatabaseHelper.getInstance();
	  	Query query = db.executeQuery("select * from rooms;");
	  	boolean exists = false;
	  	
	  	for (int i = 0; i < query.size() && !exists; i++)
	  	{
	  		int rNum = Integer.parseInt(query.get(i).get("Rnumber"));
	  		if (this.getRoomNo() == rNum)
	  		{
	  			exists = true;
	  		}
	  	}
	  	
	  	return exists;
	  	
	}
	
	public void setRoomDetails(int roomNo, String type, int status, int price)
	{
		DatabaseHelper db = DatabaseHelper.getInstance();
	  	db.executeQuery("update rooms set Type = " + type + ", Status = " + ", Price = " + price + " where Rnumber = " + roomNo);
	}

	public void getInfortmation() 
	{
	    DatabaseHelper db = DatabaseHelper.getInstance();
	    Query query = db.executeQuery("select * from rooms;");
	    
	    for(int i=0;i<query.size();i++)
	  	{
	  	  setAmountOfRooms(Integer.parseInt((query.get(i).get("Rnumber"))));
	  	  setType( query.get(i).get("Type"));
	  	  
	  	  int temp = Integer.parseInt(query.get(i).get("Status"));
	  	  if(temp==1)
	  	  {
	  	      setAvailability(true);
	  	  }else
	  	  {
	  	      setAvailability(false);
	  	  }
	  	  setPrice(Integer.parseInt(query.get(i).get("Price")));
	  	}
	    
	}
}