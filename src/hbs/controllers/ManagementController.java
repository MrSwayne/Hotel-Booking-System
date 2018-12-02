package hbs.controllers;


import hbs.models.*;
import hbs.views.ManagementView;
import hbs.views.View;

public class ManagementController extends Controller {
    	private UserModel user;
    	private ManagerModel manager;
    	private ManagementView view; 
	public ManagementController()
	{
	}
	
	

	public void checkCredentials(String username,String password)
	{
	    
	}
	
	public boolean validation(String name,String password) 
	{
		boolean valid = false;
		return valid;
	}



	@Override
	public void addObserver(View view) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void removeObserver(View view) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}
}