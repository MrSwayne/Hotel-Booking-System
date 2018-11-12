package hbs.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import hbs.managers.BookingManager;

public class BookingView extends JFrame implements ActionListener {
	JPanel mainPanel = new JPanel();
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField dateInField;
	private JTextField dateOutField;
	
	public static void main(String [] args)
	{
		BookingView run = new BookingView();
		run.book();
	}
	
	public BookingView() {
		this.setLocationRelativeTo(null);//setting to the center of the screen
		this.setVisible(true);
		this.setTitle("Booking");
	}

	protected void book() {
		mainPanel = new JPanel(new GridLayout(3,1));
		
		JPanel fName = new JPanel();
		JLabel fnameLabel = new JLabel("First Name: ",JLabel.CENTER);
		fnameField = new JTextField("",10);
		fName.add(fnameLabel);
		fName.add(fnameField);
		fName.setVisible(true);
		
		JPanel lName = new JPanel();
		JLabel lnameLabel = new JLabel("Last Name: ",JLabel.CENTER);
		lnameField = new JTextField("",10);
		lName.setVisible(true);
		lName.add(lnameLabel);
		lName.add(lnameField);

		JPanel dateInPanel = new JPanel();
		JLabel dateInLabel = new JLabel("Date in: ",JLabel.CENTER);
		dateInField = new JTextField("",10);
		dateInPanel.setVisible(true);
		dateInPanel.add(dateInLabel);
		dateInPanel.add(dateInField);

		JPanel dateOutPanel = new JPanel();
		JLabel dateOutLabel = new JLabel("Date out: ",JLabel.CENTER);
		dateOutField = new JPasswordField("",10);
		dateOutPanel.setVisible(true);
		dateOutPanel.add(dateOutLabel);
		dateOutPanel.add(dateOutField);
		
		JPanel control = new JPanel();
		control.setVisible(true);
		JButton button = new JButton("Submit");
		button.setActionCommand("submit");
		button.addActionListener(this);
		control.add(button);
		
		mainPanel.add(fName);
		mainPanel.add(lName);
		mainPanel.add(dateInPanel);
		mainPanel.add(dateOutPanel);
		mainPanel.add(control);
		this.add(mainPanel);
		this.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		BookingManager controller = new BookingManager(this);
		String btnPressed = e.getActionCommand();
		if(btnPressed.equalsIgnoreCase("submit"))
		{
				controller.checkBooking(fnameField.getText(), lnameField.getText(), dateInField.getText(), dateOutField.getText());
				this.remove(mainPanel);
			
		}
	}
}