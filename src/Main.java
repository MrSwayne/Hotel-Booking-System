
import hbs.views.LoginView;
import hbs.database.*;
import hbs.views.PaymentView;

import java.util.ArrayList;
import java.util.Map;

import hbs.controllers.LoginController;
import hbs.controllers.PaymentController;

public class Main {
    public static void main(String [] args)
    {
    	DatabaseHelper db = DatabaseHelper.getInstance();
    	Query query = db.executeQuery("select * from users;");
    	
    	for(int i = 0;i < query.size();i++) {
    		System.out.println(query.get(i).get("FirstName"));
    	}
    
	/*PaymentView payV = new PaymentView();
	PaymentController payC = new PaymentController();
	payC.addObserver(payV);*/
    	
    	LoginView loginV = new LoginView();
    	LoginController loginC = new LoginController();
    	loginC.addObserver(loginV);
    }
}