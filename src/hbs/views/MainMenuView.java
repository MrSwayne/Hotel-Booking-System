package hbs.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import hbs.controllers.BookingController;
import hbs.controllers.CancelBookingController;
import hbs.controllers.Controller;

public class MainMenuView extends View implements ActionListener{
    JPanel mainPanel = new JPanel();
    
    public  void MainMenuView() {
	this.setTitle("Login");
	mainPanel = new JPanel(new GridLayout(3,1));
	
	JPanel control = new JPanel();
	control.setVisible(true);
	JButton btn1 = new JButton("Booking");
	btn1.setActionCommand("booking");
	btn1.addActionListener(this);
	control.add(btn1);
	JButton btn2 = new JButton("Payment");
	btn2.setActionCommand("payment");
	btn2.addActionListener(this);
	control.add(btn2);
	JButton btn3 = new JButton("Cancel Booking");
	btn3.setActionCommand("cancel");
	btn3.addActionListener(this);
	control.add(btn3);
	JButton btn4 = new JButton("Logout");
	btn4.setActionCommand("logout");
	btn4.addActionListener(this);
	
	mainPanel.add(control);
	this.add(mainPanel);
	this.pack();
    }
    @Override
	public void actionPerformed(ActionEvent e) {

		String btnPressed = e.getActionCommand();
		if(btnPressed.equalsIgnoreCase("booking"))
		{
		    		
				this.remove(mainPanel);
				this.setVisible(false);
				BookingView bookingV = new BookingView();
				BookingController bookingC = new BookingController();
				bookingC.addObserver(bookingV);
				//System.exit(0);
			
		}
		else if(btnPressed.equalsIgnoreCase("payment"))
		{
			this.remove(mainPanel);
			this.setVisible(false);
			PaymentView paymentView = new PaymentView();
		}
		else if(btnPressed.equalsIgnoreCase("cancel"))
		{
		    this.remove(mainPanel);
		    this.setVisible(false);
		    CancelBookingView cancelV = new CancelBookingView();
		    CancelBookingController cancelC = new CancelBookingController();
		    cancelC.addObserver(cancelV);
		    
		}
		else if(btnPressed.equalsIgnoreCase("logout"))
		{
		    this.remove(mainPanel);
		    this.setVisible(false);
		    LoginView loginView = new LoginView();
		}
    }	
	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		
	}

}