
import hbs.views.LoginView;
import hbs.controllers.LoginController;

public class Main {
    public static void main(String [] args)
    {
	LoginView loginV = new LoginView();
	LoginController loginC = new LoginController();
	loginC.addObserver(loginV);
    }
}