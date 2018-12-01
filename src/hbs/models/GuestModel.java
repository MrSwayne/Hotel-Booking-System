package hbs.models;

public class GuestModel extends Model
{
	private int  memLev,gID;
	private String first_name, last_name;
	private String memSince;
	private double totalSpent;
	
	public GuestModel(int gID, String first_name, String last_name, String memSince, double totalSpent, int memLev) {
		this.gID = gID;
		this.first_name = first_name;
		this.last_name = last_name;
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
	
	public void setFirstName(String first_name)
	{
		this.first_name = first_name;
	}
	
	public String getFirstName()
	{
		return first_name;
	}
	
	public void setLastName(String last_name)
	{
		this.last_name = last_name;
	}
	
	public String getLastName()
	{
		return this.last_name;
	}
	
	public String getMemSince()
	{
		return memSince;
	}
	/*DATABASE
	public void getInformation() {
	    
	    
	}*/
}