package hbs.managers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.stripe.Stripe;

import hbs.models.*;
import hbs.views.*;

public class PaymentController {
	
	private static final String API_KEY = "sk_test_I4018YUPlMB3aA4fRCnSDUag";
	
	private PaymentView view;
	private PaymentModel model;
	
	public PaymentController(PaymentView view, PaymentModel model) {
		this.view = view;
		this.model = model;
		
		this.view.addPayListener(new PayListener());
	}
	
	class PayListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = null, cNumber = null, expiry = null, security = null;
			try {
				name = view.getName();
				cNumber = view.getcNumber();
				expiry = view.getExpiry();
				security = view.getSecurity();
				
				//model.setName(name);
				
				
			} catch(Exception e) {
				
			}
		}
		
	}
	
	public void processPayment(String firstName, String lastName, String cNumber) {		
		Stripe.apiKey = API_KEY;
		
		GuestModel guest = new GuestModel();
		guest.setFirstName(firstName);
		
		guest.setLastName(lastName);
		//guest.getCredentials
	}
}

