package hbs.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hbs.controllers.LoginController;

public class LoginView extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel mainPanel = new JPanel();
	private JTextField userField;
	private JTextField passwordField;
	
	public LoginView() {
		this.setTitle("Login");
		mainPanel = new JPanel(new GridLayout(3,1));
		
		JPanel user = new JPanel();
		JLabel userLabel = new JLabel("Username: ",JLabel.CENTER);
		userField = new JTextField("",10);
		
		user.add(userLabel);
		user.add(userField);
		user.setVisible(true);
		
		JPanel password = new JPanel();
		JLabel passwrodLabel = new JLabel("Password: ",JLabel.CENTER);
		passwordField = new JTextField("",10);
		password.setVisible(true);
		password.add(passwrodLabel);
		password.add(passwordField);
		
		JPanel control = new JPanel();
		control.setVisible(true);
		JButton button = new JButton("Login");
		button.setActionCommand("login");
		button.addActionListener(this);
		control.add(button);
		
		mainPanel.add(user);
		mainPanel.add(password);
		mainPanel.add(control);
		this.add(mainPanel);
		this.pack();
	}
	
	public void remove() {
	    this.setVisible(false);
	    this.remove(mainPanel);
	    MainMenuView mainMenu = new MainMenuView();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    LoginController control = new LoginController();
	    control.addObserver(this);
		String btnPressed = e.getActionCommand();
		if(btnPressed.equalsIgnoreCase("login"))
		{
			control.checkCredentials(userField.getText(), passwordField.getText());
			}else {
				System.exit(0);
			}
		}
}