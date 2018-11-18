package hbs.manager;


import hbs.views.LoginView;
import hbs.models.LoginModel;

//import view and model.
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
	    System.out.println("work?");
	   // if(username != null && password != null)
	   // {
		if(username.equals(model.getUsername()) && password.equals(model.getPassword()))
		{
		    return true;
		}else {
		    return false;
		}
	   
	  //  }
	   // return false;
	}
}