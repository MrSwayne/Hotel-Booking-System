package hbs.Views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import hbs.Views.*;

public class MainMenuView extends JFrame implements ActionListener {
    JPanel mainPanel = new JPanel();
    public void Menu() {
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setLocationRelativeTo(null);//setting to the center of the screen
	this.setVisible(true);
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
	
	
	mainPanel.add(control);
	this.add(mainPanel);
	this.pack();
    }
    @Override
	public void actionPerformed(ActionEvent e) {
	    	BookingView view1 = new BookingView();
	    	PaymentView view2 = new PaymentView();
		String btnPressed = e.getActionCommand();
		if(btnPressed.equalsIgnoreCase("booking"))
		{
		    		
				this.remove(mainPanel);
				this.setVisible(false);
				view1.Booking();
				//System.exit(0);
			
		}
		else if(btnPressed.equalsIgnoreCase("payment"))
		{
			this.remove(mainPanel);
			this.setVisible(false);
			view2.PaymentView();
		}
    }

}