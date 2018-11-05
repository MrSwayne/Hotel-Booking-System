package Models;

public class GuestModel
{
	private int gID, totalSpent, memLev;
	private String first_name, last_name;
	private date memSince;
	
	public int getGID()
	{
		return gID;
	}
	
	public void setTotalSpent(int total)
	{
		this.totalSpent = total;
	}
	
	public int getTotalSpent()
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
	
	public void setFirstName(String first_name)
	{
		this.first_name = first_name;
	}
	
	public String getFirstName()
	{
		return first_name;
	}
	
	public setLastName(String last_name)
	{
		this.last_name = last_name;
	}
	
	public date getMemSince()
	{
		return memSince;
	}
}