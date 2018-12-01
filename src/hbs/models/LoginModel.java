package hbs.models;



import hbs.database.DatabaseHelper;
import hbs.database.Query;

//import java.sql.Connection;

import hbs.interfaces.IUser;

public class LoginModel extends Model implements IUser
{
	private String username, password;
	//private Connection conn;
	public LoginModel()
	{
		
	}
	
	public void setFirstName (String username){
		this.username = username;
	}
	
	public String getFirstName(){
		return username;
	}
	@Override
	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}
	//Method for setting the password and username from db
	public void getCredentials()
	  {
	  	DatabaseHelper db = DatabaseHelper.getInstance();
	  	Query query = db.executeQuery("select * from users;");
	  	
	  	for(int i=0;i<query.size();i++)
	  	{
	  	  String username = query.get(i).get("FirstName");
	  	  String password = query.get(i).get("Password");
	  	  if(this.getFirstName().equals(username)) {
	  	      this.setPassword(password);
	  	  }
	  	}
	  	
	  	
	  }

	@Override
	public int getUID() {
	    // TODO Auto-generated method stub
	    return 0;
	}
	  
	
}

	
