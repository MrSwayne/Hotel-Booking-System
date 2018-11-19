package hbs.models;

import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.Connection;

import hbs.interfaces.IUser;

public class LoginModel extends Model implements IUser
{
	private String username, password;
	//private Connection conn;
	public LoginModel()
	{
		
	}
	
	public void setUsername (String username){
		this.username = username;
	}
	@Override
	public String getUsername(){
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
	/*public void getCredentials()
	  {
	  	try
	 	{
	  		//COnnecting to database etc.
	  		String select= ("Select * from users where FirstName = ? AND Password = ?");
	  		ResultSet rs = select.executeQuery();
	  		if(rs.next()) {
	  		    password = rs.getString("password");
	  		}else {
	  		    password = "";
	  		}
	  	}catch (ClassNotFoundException e) {
	  	    e.printStackTrace();
	  	}catch (SQLException e) {
	  	    e.printStackTrace();
	  	}
	  	finally {
	  	    try {
	  		conn.close();
	  	    }catch (SQLException e) {
	  		e.printStackTrace();
	  	    }
	  	}
	  }*/
	  
	
}

	
