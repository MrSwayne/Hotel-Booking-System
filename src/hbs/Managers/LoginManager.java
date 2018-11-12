package hbs.managers;


import hbs.models.LoginModel;
import hbs.views.LoginView;
//import view and model.
public class LoginManager{
	private LoginView view;
	private LoginModel model;

	public LoginManager(LoginView view)
	{
		this.view = view;
		model = new LoginModel();
	}

	public void checkCredentials(String username,String password){
		model.setUsername(username);
		model.getCredentials();
		if(password.equals(model.getPassword())){
			view.setMessage("Login Success!");
		}else{
			view.setMessage("Login Failed! Try Again.");
		}
	}
}