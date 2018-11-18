package hbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hbs.Models.*;
import hbs.Views.*;

public class PaymentController extends Controller {
	
	private static final String API_KEY = "sk_test_I4018YUPlMB3aA4fRCnSDUag";
	
	private PaymentView view;
	private PaymentModel model;
	
	public PaymentController() {
	}
	
	@Override
	public void addObserver(View view) {
		observers.add(view);
		this.view = (PaymentView) view;
		this.view.addPayListener(new PayListener());
	}
	
	@Override
	public void removeObserver(View view) {
		observers.remove(view);
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
		//Stripe.apiKey = API_KEY;
		
		GuestModel guest = new GuestModel();
		guest.setFirstName(firstName);
		
		guest.setLastName(lastName);
		//guest.getCredentials
	}
}
