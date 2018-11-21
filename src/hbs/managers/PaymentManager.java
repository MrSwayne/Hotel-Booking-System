package hbs.managers;

import hbs.models.BookingModel;
import hbs.models.GuestModel;
import hbs.models.PaymentModel;
import hbs.views.PaymentView;


import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

public class PaymentManager {
	
	private static final String API_KEY = "sk_test_I4018YUPlMB3aA4fRCnSDUag";
	
	public PaymentManager() {
	}
	
	public void processPayment(String name, String cNumber, String expiry, String security) {		
		Stripe.apiKey = API_KEY;
		
		GuestModel guest = new GuestModel();
		String[] names = name.split(" ");
		
		if(names.length == 2) {
			guest.setFirstName(names[0]);
			guest.setLastName(names[1]);
		} else if(names.length == 3) {
			guest.setFirstName(names[0]);
			guest.setLastName(names[2]);
		} else {
			guest.setFirstName(names[0]);
		}
		/*
		
		if(guest.getCredentials()) {
			int GID = guest.getGID();
			
			BookingModel booking = new BookingModel();
			booking.setGID(GID);
			
			if(booking.getCredentials()) {
				
			} else
				System.err.println("Error retrieving bookings");
		} else
			System.err.println("Error retrieving guest");
			*/
	}
}

