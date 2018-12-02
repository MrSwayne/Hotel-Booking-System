package hbs.models;



import hbs.database.DatabaseHelper;
import hbs.database.Query;

public class BookingModel extends Model
{
	private int gID, rID, bID,nights; 
	private String date_in, date_out;
	final static String dateFormat = "dd/MM/yy";
	
	public BookingModel()
	{
		
	}
	
	public int getGID()
	{
		return gID;
	}
	
	public int getRID()
	{
		return rID;
	}
	
	public int getBID()
	{
		return bID;
	}
	
	public void setBID(int bID)
	{
	    this.bID= bID;
	}

	public void setDateIn(String date)
	{
		this.date_in = date;
	}
	
	public String getDateIn()
	{
		return date_in;
	}
	
	public void setDateOut(String date)
	{
		this.date_out = date;
	}
	
	public String getDateOut()
	{
		return date_out;
	}
	
	public int getAmountOfNights()
	{
	    return nights;
	}
	
	public void setAmountOfNights(int nights)
	{
	    this.nights=nights;
	}

	public void getInformation() {
	    DatabaseHelper db = DatabaseHelper.getInstance();
	    Query query = db.executeQuery("select * from bookings;");

	  	for(int i=0;i<query.size();i++)
	  	{
	  	  int bID = Integer.parseInt(query.get(i).get("Bid"));
	  	  
		    String date_In = (query.get(i).get("dateIn"));
		    String date_Out = (query.get(i).get("dateOut"));	  
	  	  
	  	  
	  	  if(this.getBID()!=bID)
	  	  {
	  	      if(this.getDateIn().equals(date_In) && this.getDateOut().equals(date_Out))
	  	      {
	  		  System.out.println("Those dates are already taken");
	  	      }
	  	      else {
	  		  //do something
	  	      }
	  	  }
	  	  else
	  	  {
	  	      System.out.println("This bookign alreayd exists");
	  	  }
	  	  
	  	}
	    
	}
	/*MEthod to insert new booking into the db
	public void setBooking() {
	    DatabaseHelper db = DatabaseHelper.getInstance();
	     db.executeQuery("INSERT INTO bookings VALUES(default,"+this.getDateIn()+","+this.getDateOut()+","+this.getGID()+"," + this.getRID()+");");	    
	}*/
}
