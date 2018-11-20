package hbs.views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CancelBookingView extends View {
	JPanel mainPanel = new JPanel();
	
	private JTextField cancelField;
	private JPasswordField passwordField;
	private JButton submitBtn;
    public CancelBookingView(){
	this.setTitle("Login");
	mainPanel = new JPanel(new GridLayout(3,1));
	
	JPanel cancelID = new JPanel();
	JLabel cancelLabel = new JLabel("Booking ID: ",JLabel.CENTER);
	cancelField = new JTextField("",10);
	cancelID.add(cancelLabel);
	cancelID.add(cancelField);
	
	JPanel password = new JPanel();
	JLabel passwrodLabel = new JLabel("Password: ",JLabel.CENTER);
	passwordField = new JPasswordField("",10);
	password.add(passwrodLabel);
	password.add(passwordField);
	
	JPanel control = new JPanel();
	submitBtn = new JButton("Submit");
	control.add(submitBtn);
	
	mainPanel.add(cancelID);
	mainPanel.add(password);
	mainPanel.add(control);
	
	this.add(mainPanel);
	this.setVisible(true);
	this.pack();
    }
    
    public String getBookingID() {
	    return cancelField.getText();
	}
	public String getPassword() {
	    return new String (passwordField.getPassword());
	}
	
	public void addCancelListener(ActionListener listen)
	{
	    submitBtn.addActionListener(listen);
	}
	
	public void displayMessage(String message)
	{
	    JOptionPane.showMessageDialog(this,message);
	}
    @Override
    public void setMessage(String message) {
	// TODO Auto-generated method stub
	
    }

}
