package hbs.Models;

public class UserModel
{
	private String firstName, lastName, password,uID,hID;
	private boolean isManager;	
	
	public UserModel(String uID, String firstName, boolean isManager, String hID) {
		this.uID = uID;
		this.firstName = firstName;
		this.isManager = isManager;
		this.hID = hID;
	}

	public UserModel() {
		
	}

	public String getUID()
	{
		return uID;
	}
	
	public String getHID()
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