package hbs.models;

import hbs.interfaces.IUser;

public class UserModel implements IUser
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
	
	
	public boolean getIsManager()
	{
		return isManager;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
}