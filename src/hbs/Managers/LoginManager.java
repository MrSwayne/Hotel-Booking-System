package hbs.Managers;


import hbs.Models.LoginModel;
import hbs.Views.LoginView;
import hbs.database.LoginDBController;
//import view and model.
public class LoginManager{
	public LoginManager(LoginView view)
	{
		new LoginModel();
	}

	public boolean checkCredentials(String username,String password){
		LoginDBController db = new LoginDBController();
		db.verifyLoginDetails(username, password);
		if(db.validation(username, password))
		{
			return true;
		}
		else {
			return false;
		}
	}
}