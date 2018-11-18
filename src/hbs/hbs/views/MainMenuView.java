package hbs.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenuView extends View {
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
	JButton btn3 = new JButton("Logout");
	btn3.setActionCommand("logout");
	btn3.addActionListener(this);
	control.add(btn3);
	
	
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
		    	BookingView bookingView = new BookingView();
				//System.exit(0);
			
		}
		else if(btnPressed.equalsIgnoreCase("payment"))
		{
			this.remove(mainPanel);
			this.setVisible(false);
	    	PaymentView paymentView = new PaymentView();
		}
		else if(btnPressed.equalsIgnoreCase("logout"))
		{
		    this.remove(mainPanel);
		    this.setVisible(false);
		    LoginView loginView = new LoginView();
		}
    }

}