package hbs.Managers;


import hbs.Models.LoginModel;

public class LoginManager{
    	private LoginModel model;
	public LoginManager()
	{
	}

	public boolean checkCredentials(String username,String password)
	{
	    //change it to a method in model which will set the info from the database.
	    model.setUsername("Patryk");
	    model.setPassword("easy");
	    if(username != null && password != null)
	    {
		if(username.equals(model.getUsername()) && password.equals(model.getPassword()))
		    return true;
	    }
	    return false;
	}
}

