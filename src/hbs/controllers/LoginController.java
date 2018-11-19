package hbs.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hbs.views.LoginView;
import hbs.views.MainMenuView;
import hbs.views.View;
import hbs.managers.LoginManager;

public class LoginController extends Controller {
    	private MainMenuView view2;
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
		System.out.println("HELP!!");
		try {
		    LoginManager manager = new LoginManager();
		    if(manager.checkCredentials(view.getUsername(), view.getPassword()))
		    {
			MainMenuView view2 = new MainMenuView();
		  	 view2.MainMenuView();
		    }
		    else {
			System.out.println("WTF");
		    }
		}catch(Exception e) {
		    
		}
		
	    }
	    
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}
}