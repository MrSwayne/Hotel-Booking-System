package hbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hbs.controllers.LoginController.LoginListener;
import hbs.managers.LoginManager;
import hbs.state_pattern.CheckIn;
import hbs.state_pattern.CheckOut;
import hbs.state_pattern.Context;
import hbs.views.CheckView;
import hbs.views.LoginView;
import hbs.views.View;

public class CheckController extends Controller {
    
    public CheckController()
	{
	}
    @Override
    public void addObserver(View view) {
	observers.add(view);
	CheckView checkView = (CheckView) view;
	CheckListener listener = new CheckListener(checkView); 
	checkView.addCheckListener(listener);
    }

    @Override
    public void removeObserver(View view) {
	observers.remove(view);
	
    }
    
    class CheckListener implements ActionListener{
	
	private CheckView view;
	
	public CheckListener(CheckView view) {
		this.view = view;
	}
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
	try {
	    Context context = new Context();
	    CheckIn checkIn = new CheckIn();
	    checkIn.action(context);
	    
	    System.out.println(context.getCheck().toString());
	    
	    CheckOut checkOut = new CheckOut();
	    checkOut.action(context);
	    
	    System.out.println(context.getCheck().toString());
	}catch(Exception e) {
	    
	}
	
    }
    
}

    @Override
    public void notifyObservers() {
	// TODO Auto-generated method stub
	
    }

}
