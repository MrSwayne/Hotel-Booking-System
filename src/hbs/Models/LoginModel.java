package hbs.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginModel
{
	private String username, password;
	private Connection conn;

	public LoginModel()
	{
		
	}
	
	public void setUsername (String username){
		this.username = username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}
	
	public boolean doesPasswordEqual(String password) {
		return this.password.equals(password);
	}
	public void getCredentials(){
			if(user_map.containsKey(username))
			{
				if(user_map.get(username).doesPasswordEqual(password))
				{
					//Correct password -> main menu,booking view etc.
				}else {
					//IncorrectPassword -> retry
				}
			}
        }
}

	
