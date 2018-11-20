package hbs.models;
import java.util.*;
import hbs.interfaces.IUser;

public class ManagerModel extends Model implements IUser
{
	private int uID, hID;
	private String firstName, lastName, password;
	private List<UserModel> subordinates;
	
	public ManagerModel()
	{
		subordinates = new ArrayList<UserModel>();
	}
	
	public ManagerModel(int uID, int hID, String firstName, String lastName, String password)
	{
		this.uID = uID;
		this.hID = hID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		subordinates = new ArrayList<UserModel>();
	}
	
	public void add(UserModel u)
	{
		subordinates.add(u);
	}
	
	public void remove(UserModel u)
	{
		if (subordinates.contains(u))
		{
			subordinates.remove(u);
		}
	}
	
	public List<UserModel> getSubordinates()
	{
		return subordinates;
	}
	
	public int getUID()
	{
		return uID;
	}
	
	public int getHID()
	{
		return hID;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}	
}
