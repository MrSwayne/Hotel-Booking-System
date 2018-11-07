package hbs.managers;



import com.stripe.Stripe;

import hbs.models.*;
import hbs.views.*;

public class PaymentManager {
	
	private static final String API_KEY = "sk_test_I4018YUPlMB3aA4fRCnSDUag";
	
	private PaymentView view;
	private PaymentModel model;
	
	public PaymentManager(PaymentView view, PaymentModel model) {
		this.view = view;
		this.model = model;
	}
	
	public void processPayment(String firstName, String lastName, String cNumber) {		
		Stripe.apiKey = API_KEY;
		
		GuestModel guest = new GuestModel();
		guest.setFirstName(firstName);
		
		guest.setLastName(lastName);
		//guest.getCredentials
	}
}

