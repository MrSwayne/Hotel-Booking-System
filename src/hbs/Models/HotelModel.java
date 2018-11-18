package hbs.models;

public class HotelModel extends Model
{
	private int rooms, hID;
	private String name, city, country;
	
	public HotelModel(int i, int hid2, String country2, String city2, String name2, int rooms2) {
		// TODO Auto-generated constructor stub
	}
	public int getRooms()
	{
		return rooms;
	}
	public void setRooms(int rms)
	{
	    this.rooms = rms;
	}
	
	public int getHID()
	{
		return hID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getCountry()
	{
		return country;
	}
}