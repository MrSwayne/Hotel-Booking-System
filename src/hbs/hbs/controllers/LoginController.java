package hbs.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hbs.manager.LoginManager;
import hbs.views.LoginView;
import hbs.views.MainMenuView;
import hbs.views.View;

public class LoginController extends Controller {
	private LoginView view;
	public LoginController()
	{   
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
	    public void actionPerformed(ActionEvent arg1) {
		System.out.println("HELP!!");
		try {
		    LoginManager manager = new LoginManager();
		    if(manager.checkCredentials(view.getUsername(), view.getPassword()))
		    {
			MainMenuView view2 = new MainMenuView();
			observers.add(view2);
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