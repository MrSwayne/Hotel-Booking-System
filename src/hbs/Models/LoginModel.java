package hbs.models;

public class LoginModel
{
	private String username, password;

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

	/*public void getCredentials(){
		database stuff done here.
	}*/
}
