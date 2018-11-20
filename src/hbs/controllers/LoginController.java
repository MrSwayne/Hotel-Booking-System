package hbs.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hbs.views.LoginView;
import hbs.views.MainMenuView;
import hbs.views.View;
import hbs.managers.LoginManager;

public class LoginController extends Controller {
	public LoginController()
	{
	}
	@Override
	public void addObserver(View view)
	{
	    observers.add(view);
	    LoginView loginView = (LoginView) view;
	    LoginListener listener = new LoginListener(loginView); 
            loginView.addLoginListener(listener);
       //     System.out.println(observers.get(0));
	}
	
	@Override
	public void removeObserver(View view) {
	    observers.remove(view);
	}
	
	class LoginListener implements ActionListener{
		
		private LoginView view;
		
		public LoginListener(LoginView view) {
			this.view = view;
		}
	    
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		try {
		    LoginManager loginManager = new LoginManager();
		    LoginController loginC = new LoginController();
		    if(loginManager.checkCredentials(view.getUsername(), view.getPassword()))
		    {
			loginC.notifyObservers();
		    }
		    else {
			System.out.println("Error-Wrong Credentials");
		    }
		}catch(Exception e) {
		    
		}
		
	    }
	    
	}

	@Override
	public void notifyObservers() {
		MainMenuView view2 = new MainMenuView();
		view2.MainMenuView();
	}
}