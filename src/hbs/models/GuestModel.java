package hbs.models;

import java.sql.ResultSet;
import java.util.HashMap;

import hbs.database.DatabaseHelper;
import hbs.database.Query;

public class GuestModel extends Model
{
	private int memLev,gID;
	private double totalSpent;
	private String firstName = null, lastName = null;
	private java.util.Date memSince = null;
	
	
	public GuestModel(int gID, String firstName, String lastName, java.util.Date memSince, int totalSpent, int memLev) {
		this.gID = gID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.memSince = memSince;
		this.totalSpent = totalSpent;
		this.memLev = memLev;
	}

	public GuestModel() {
	}

	public int getGID()
	{
		return gID;
	}
	
	public void setTotalSpent(double total)
	{
		this.totalSpent = total;
	}
	
	public double getTotalSpent()
	{
		return totalSpent;
	}
	
	public void setMemLev(int level)
	{
		this.memLev = level;
	}
	
	public int getMemLev()
	{
		return memLev;
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
		return this.lastName;
	}
	
	public java.util.Date getMemSince()
	{
		return memSince;
	}
	
	public boolean getCredentials() {
		DatabaseHelper db = DatabaseHelper.getInstance();
		
		if(this.firstName == null && this.lastName == null) return false;
		
		String sql = "SELECT DISTINCT(Gid) FROM GUESTS WHERE ";
		
		if(gID == 0) {
			
			if(this.firstName != null ) {
				sql += "FirstName = '" + this.firstName + "'";
			}
			if(this.lastName != null) {
				sql += " AND LastName = '" + this.lastName + "'";
			}
		} else {
			sql += "GID = '" + this.gID + "'";
		}
		
		sql += ";";
		
		Query query = db.executeQuery(sql);
	
		if(query.isEmpty())	return false;
		this.gID = (Integer.parseInt(query.get(0).get("Gid")));
		return true;
	}
}