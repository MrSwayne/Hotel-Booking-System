package hbs.models;
import hbs.interfaces.IEmployee;
import hbs.interfaces.IUser;

import hbs.database.DatabaseHelper;
import hbs.database.Query;

public class UserModel extends Model implements IUser, IEmployee
{
	private int uID, hID;
	private String firstName, lastName, password;
	private double wages;
	public UserModel()
	{}
	
	public UserModel(int uID, int hID, String firstName, String lastName, String password, double wages)
	{
		this.uID = uID;
		this.hID = hID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.wages = wages;
	}
	
	public int getUID()
	{
		return uID;
	}
	
	public void setUID(int uID)
	{
		this.uID = uID;
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

	@Override
	public double getWages() {
		return wages;
	}
	
	public void setWages(double wages)
	{
		this.wages = wages;
	}
	
	public boolean checkUID()
	{
		boolean exists = false;
		DatabaseHelper db = DatabaseHelper.getInstance();
	  	Query query = db.executeQuery("select * from rooms;");
	  	
	  	for (int i = 0; i < query.size() && !exists; i++)
	  	{
	  		int uNum = Integer.parseInt(query.get(i).get("Uid"));
	  		if (this.getUID() == uNum)
	  		{
	  			exists = true;
	  		}
	  	}
		return exists;
	}
	
	public void setUserDetails(int uNum, String firstName, String lastName, String password, int wages)
	{
		DatabaseHelper db = DatabaseHelper.getInstance();
	  	db.executeQuery("update users set FirstName = " + firstName + ", LastName = " + lastName + ", Password = " + password + ", Wages = " + wages + " where Uid = " + uNum);
	}
	
}
