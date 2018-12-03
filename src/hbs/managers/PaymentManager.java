package hbs.managers;

import hbs.database.DatabaseHelper;
import hbs.database.Query;
import hbs.models.BookingModel;
import hbs.models.GuestModel;
import hbs.models.PaymentModel;
import hbs.views.PaymentView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;

public class PaymentManager {
	
	private static final String API_KEY = "sk_test_I4018YUPlMB3aA4fRCnSDUag";
	
	public PaymentManager() {
	}
	
	public void processPayment(ArrayList<Integer> bookings, String name, String cNumber, String expiry, String security) {		
		Stripe.apiKey = API_KEY;
		
		
		DatabaseHelper db = DatabaseHelper.getInstance();
		
		BookingManager mngr = new BookingManager();
		
		double charge = 0;
		for(int i = 0;i < bookings.size();i++) {
			String sql = "SELECT * FROM BOOKINGS WHERE Bid=" + bookings.get(i) + ";";
			Query bookingQuery = db.executeQuery(sql);
			
			
			for(int j = 0;j < bookingQuery.size();j++) {
				String dateIn = bookingQuery.get(j).get("DateIn");
				String dateOut = bookingQuery.get(j).get("DateOut");
				String RID = bookingQuery.get(j).get("Rid");
				
				sql = "SELECT * FROM rooms WHERE Rid=" + RID + ";";
				Query roomQuery = db.executeQuery(sql);
				String price = roomQuery.get(j).get("Price");
				String type = roomQuery.get(j).get("Type");
				
				GuestModel model = new GuestModel();
				String firstName = bookingQuery.get(j).get("FirstName");
				String lastName = bookingQuery.get(j).get("LastName");
				model.setFirstName(firstName);
				model.setLastName(lastName);
				model.getCredentials();
				
				charge += mngr.calculateTotalSpent(firstName, lastName, dateIn, dateOut, price, type);
			}
		}
		
		
		/*
		 * 
		 * 
		 * The user is supposed to enter their details to
		 * a stripe client. 
		 * 
		 * 
		 * 
	<form action="processPayment.php" method="POST">
  <script
    src="https://checkout.stripe.com/checkout.js" class="stripe-button"
    data-key="pk_test_TYooMQauvdEDq54NiTphI7jx"
    data-amount="charge"
    data-name="Stripe.com"
    data-description="Widget"
    data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
    data-locale="auto"
    data-zip-code="true">
  </script>
</form>
		 * 
		 *
		 * 
		 * 
		 */
		//String token = request.getParameter("stripeToken");
		
		
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", charge);
		chargeParams.put("currency", "eur");
		chargeParams.put("description", "Charge for booking from Shamble Hotel Group.");
		chargeParams.put("source",  "tok_mastercard");
		
		RequestOptions options = RequestOptions
				.builder()
				.setIdempotencyKey("MlfASRDecHaFSAUC")
				.build();
		
		try {
			Charge.create(chargeParams,options);
			
			String sql = "INSERT INTO PAYMENTS ";
			
		} catch (StripeException e) {
			e.printStackTrace();
		}
		
	}
}

