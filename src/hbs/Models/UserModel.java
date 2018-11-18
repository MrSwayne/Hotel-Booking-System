package hbs.Models;
import hbs.interfaces.IUser;

public class UserModel extends Model implements IUser
{
	private int uID, hID;
	private String firstName, lastName, password;
	
	public UserModel()
	{}
	
	public UserModel(int uID, int hID, String firstName, String lastName, String password)
	{
		this.uID = uID;
		this.hID = hID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
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
