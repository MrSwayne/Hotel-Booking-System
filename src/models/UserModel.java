package hbs.models;

public class UserModel
{
	private int uID, hID;
	private String firstName, lastName, password;
	private boolean isManager;	
	
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