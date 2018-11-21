package hbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hbs.managers.PaymentManager;
import hbs.models.PaymentModel;
import hbs.views.PaymentView;
import hbs.views.View;

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
				
				System.out.println("Weeell");
				
				name = view.getName();
				cNumber = view.getcNumber();
				expiry = view.getExpiry();
				security = view.getSecurity();
				
				PaymentManager paymentManager = new PaymentManager();
				paymentManager.processPayment(name, cNumber, expiry, security);
				
				//model.setName(name);
				
				
			} catch(Exception e) {
				
			}
		}
		
	}
	
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}
}
