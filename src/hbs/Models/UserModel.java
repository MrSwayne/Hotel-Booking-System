package hbs.models;
import java.util.*;

public class UserModel extends Model
{
	private int uID, hID;
	private String firstName, lastName, password;
	private boolean isManager;
	private List<UserModel> subordinates;
	
	public UserModel()
	{
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
	
	public void setIsManager(boolean isManager)
	{
		this.isManager = isManager;
	}
	
	public boolean getIsManager()
	{
		return isManager;
	}
}
