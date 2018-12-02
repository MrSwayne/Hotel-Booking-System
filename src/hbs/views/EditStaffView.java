package hbs.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditStaffView extends View  
{
	JPanel mainPanel = new JPanel();
	private JTextField userID;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField password;
	private JTextField wages;
	private JButton edit;
	
	public EditStaffView() 
	{
		this.setTitle("Edit Staff");
		mainPanel = new JPanel(new GridLayout(4,1));
		
		JPanel userIDPanel = new JPanel();
		JLabel userIDLabel = new JLabel("User ID: ",JLabel.CENTER);
		userID = new JTextField("",10);
		userIDPanel.add(userIDLabel);
		userIDPanel.add(userID);
		
		JPanel firstNamePanel = new JPanel();
		JLabel firstNameLabel = new JLabel("First Name: ",JLabel.CENTER);
		firstName = new JTextField("",10);
		firstNamePanel.add(firstNameLabel);
		firstNamePanel.add(firstName);
		
		JPanel lastNamePanel = new JPanel();
		JLabel lastNameLabel = new JLabel("Last Name: ",JLabel.CENTER);
		lastName = new JTextField("",10);
		lastNamePanel.add(lastNameLabel);
		lastNamePanel.add(lastName);
		
		JPanel passwordPanel = new JPanel();
		JLabel passwordLabel = new JLabel("Password: ",JLabel.CENTER);
		password = new JTextField("",10);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(password);
		
		JPanel wagesPanel = new JPanel();
		JLabel wagesLabel = new JLabel("Wages: ",JLabel.CENTER);
		wages = new JTextField("",10);
		wagesPanel.add(wagesLabel);
		wagesPanel.add(wages);
		
		JPanel control = new JPanel();
		edit = new JButton("Edit");
		control.add(edit);
		
		mainPanel.add(userIDPanel);
		mainPanel.add(firstNamePanel);
		mainPanel.add(lastNamePanel);
		mainPanel.add(passwordPanel);
		mainPanel.add(wagesPanel);
		mainPanel.add(control);
		
		this.add(mainPanel);
		this.setVisible(true);
		this.pack();
	}
	
	public String getUserID() {
	    return userID.getText();
	}
	public String getFirstName() {
	    return firstName.getText();
	}
	public String getLastName() {
	    return lastName.getText();
	}
	public String getPassword() {
	    return password.getText();
	}
	public String getWages() {
	    return wages.getText();
	}
	
	public void addEditStaffListener(ActionListener listen)
	{
	    edit.addActionListener(listen);
	}
	
	public void displayMessage(String message)
	{
	    JOptionPane.showMessageDialog(this,message);
	}
	
	@Override
	public void setMessage(String message) 
	{
	    // TODO Auto-generated method stub
	    
	}	

}
	