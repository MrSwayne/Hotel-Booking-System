package hbs.models;

public class HotelModel
{
	private int rooms, hID;
	private String name, city, country;
	
	public int getRooms()
	{
		return rooms;
	}
	public int setRooms(int rms)
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