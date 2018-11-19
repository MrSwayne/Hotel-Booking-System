package hbs.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hbs.controllers.BookingController;

public class BookingView extends View implements ActionListener {
	JPanel mainPanel = new JPanel();
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField dateInField;
	private JTextField dateOutField;
	private JTextField roomsBooked;
	private JTextField type;
	
	public void Booking() {
		this.setTitle("Booking");
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
		dateOutField = new JTextField("",10);
		dateOutPanel.setVisible(true);
		dateOutPanel.add(dateOutLabel);
		dateOutPanel.add(dateOutField);
		
		JPanel roomsPanel = new JPanel();
		JLabel roomLabel = new JLabel("Rooms: ",JLabel.CENTER);
		roomsBooked= new JTextField("",10);
		roomsPanel.setVisible(true);
		roomsPanel.add(roomLabel);
		roomsPanel.add(roomsBooked);
		
		JPanel typePanel = new JPanel();
		JLabel typeLabel = new JLabel("Type: ",JLabel.CENTER);
		type = new JTextField("",10);
		typePanel.setVisible(true);
		typePanel.add(typeLabel);
		typePanel.add(type);
		
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
		mainPanel.add(typePanel);
		mainPanel.add(roomsPanel);
		mainPanel.add(control);
		this.add(mainPanel);
		this.pack();
	}

@Override
public void actionPerformed(ActionEvent e) {
	String btnPressed = e.getActionCommand();
	BookingController controller = new BookingController();
	controller.addObserver(this);
	
	if(btnPressed.equalsIgnoreCase("submit"))
		{
			controller.makeBooking(fnameField.getText(), lnameField.getText(), dateInField.getText(), dateOutField.getText(),roomsBooked.getText(),type.getText());
			this.remove(mainPanel);
		
		}
	}

@Override
public void setMessage(String message) {
	// TODO Auto-generated method stub
	
}
}