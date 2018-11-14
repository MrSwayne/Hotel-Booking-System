package hbs.Models;

public class LoginModel
{
	private String username, password;

	public LoginModel()
	{
		
	}
	
	public void setUsername (String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}
	//Method for setting the password and username from db
}

	
