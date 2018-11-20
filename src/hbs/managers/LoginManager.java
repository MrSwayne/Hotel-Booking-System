package hbs.managers;


import hbs.models.LoginModel;

public class LoginManager{
    	private LoginModel model = new LoginModel();
	public LoginManager()
	{
	}

	public boolean checkCredentials(String username,String password)
	{
	    //change it to a method in model which will set the info from the database.
	    model.setFirstName("Patryk");
	    model.setPassword("easy");
	    if(username != null && password != null)
	    {
		if(username.equals(model.getFirstName()) && password.equals(model.getPassword()))
		    return true;
	    }
	    return false;
	}
}

