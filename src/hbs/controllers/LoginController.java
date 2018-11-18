package hbs.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hbs.Managers.LoginManager;
import hbs.Views.LoginView;
import hbs.Views.MainMenuView;
import hbs.Views.View;

public class LoginController extends Controller {
    	private LoginView view;
    	private MainMenuView view2;
	public LoginController(LoginView view)
	{
	    this.view = view;
	}
	
	@Override
	public void addObserver(View view)
	{
	    observers.add(view);
	    this.view = (LoginView) view;
            this.view.addLoginListener(new LoginListener());
	}
	
	@Override
	public void removeObserver(View view) {
	    observers.remove(view);
	}
	
	class LoginListener implements ActionListener{
	    
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
}