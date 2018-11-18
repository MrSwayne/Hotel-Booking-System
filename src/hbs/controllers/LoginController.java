package hbs.controllers;


import hbs.models.LoginModel;
import hbs.views.LoginView;

public class LoginController extends Controller {
    	private LoginModel model;
    	private LoginView view; 
	public LoginController()
	{
	}
	
	

	public void checkCredentials(String username,String password)
	{
	    //change it to a method in model which will set the info from the database.
	    model.setUsername("Patryk");
	    model.setPassword("easy");
	    if(username != null && password != null)
	    {
		if(validation(username, password))
		{
		    view.remove();
		}
		else {
			System.exit(0);
			view.remove();
	    		}
	    }   
	}
	public boolean validation(String name,String password) {
		if(name.equals(model.getUsername()) && password.equals(model.getPassword())){
			return true;
		}else {
			return false;
		}
	}
}