package hbs.views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel mainPanel = new JPanel();
	private JTextField userField;
	private JPasswordField passwordField;
	
	private JButton loginBtn;
	
	public LoginView() {
		this.setTitle("Login");
		mainPanel = new JPanel(new GridLayout(3,1));
		
		JPanel user = new JPanel();
		JLabel userLabel = new JLabel("Username: ",JLabel.CENTER);
		userField = new JTextField("",10);
		user.add(userLabel);
		user.add(userField);
		
		JPanel password = new JPanel();
		JLabel passwrodLabel = new JLabel("Password: ",JLabel.CENTER);
		passwordField = new JPasswordField("",10);
		password.add(passwrodLabel);
		password.add(passwordField);
		
		JPanel control = new JPanel();
		loginBtn = new JButton("Login");
		control.add(loginBtn);
		
		mainPanel.add(user);
		mainPanel.add(password);
		mainPanel.add(control);
		
		this.add(mainPanel);
		this.setVisible(true);
		this.pack();
	}
	public String getUsername() {
	    return userField.getText();
	}
	public String getPassword() {
	    return new String (passwordField.getPassword());
	}
	
	public void addLoginListener(ActionListener listen)
	{
	    loginBtn.addActionListener(listen);
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