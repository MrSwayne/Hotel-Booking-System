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

import hbs.controllers.BookingController;

public class BookingView extends View {
	JPanel mainPanel = new JPanel();
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField dateInField;
	private JTextField dateOutField;
	private JTextField roomsBooked;
	private JTextField type;
	private JButton submitBtn;
	private JButton cancelBtn;
	
	public  BookingView() {
		this.setTitle("Booking");
		mainPanel = new JPanel(new GridLayout(3,1));
		
		JPanel fName = new JPanel();
		JLabel fnameLabel = new JLabel("First Name: ",JLabel.CENTER);
		fnameField = new JTextField("",10);
		fName.add(fnameLabel);
		fName.add(fnameField);
		
		JPanel lName = new JPanel();
		JLabel lnameLabel = new JLabel("Last Name: ",JLabel.CENTER);
		lnameField = new JTextField("",10);
		lName.add(lnameLabel);
		lName.add(lnameField);

		JPanel dateInPanel = new JPanel();
		JLabel dateInLabel = new JLabel("Date in: ",JLabel.CENTER);
		dateInField = new JTextField("",10);
		dateInPanel.add(dateInLabel);
		dateInPanel.add(dateInField);

		JPanel dateOutPanel = new JPanel();
		JLabel dateOutLabel = new JLabel("Date out: ",JLabel.CENTER);
		dateOutField = new JTextField("",10);
		dateOutPanel.add(dateOutLabel);
		dateOutPanel.add(dateOutField);
		
		JPanel roomsPanel = new JPanel();
		JLabel roomLabel = new JLabel("Rooms: ",JLabel.CENTER);
		roomsBooked= new JTextField("",10);
		roomsPanel.add(roomLabel);
		roomsPanel.add(roomsBooked);
		
		JPanel typePanel = new JPanel();
		JLabel typeLabel = new JLabel("Type: ",JLabel.CENTER);
		type = new JTextField("",10);
		typePanel.setVisible(true);
		typePanel.add(typeLabel);
		typePanel.add(type);
		
		JPanel control = new JPanel();
		submitBtn = new JButton("Submit");
		control.add(submitBtn);
		
		mainPanel.add(fName);
		mainPanel.add(lName);
		mainPanel.add(dateInPanel);
		mainPanel.add(dateOutPanel);
		mainPanel.add(typePanel);
		mainPanel.add(roomsPanel);
		mainPanel.add(control);
		this.add(mainPanel);
		this.setVisible(true);
		this.pack();
	}


	public String getFirstName() {
	    return fnameField.getText();
	}
	public String getLastName() {
	    return lnameField.getText();
	}
	public String getDateIn() {
	    return dateInField.getText();
	}
	public String getDateOut() {
	    return dateOutField.getText();
	}
	public String getRoomType() {
	    return type.getText();
	}
	public String getRoomAmount() {
	    return roomsBooked.getText();
	}
	
	public void addBookingListener(ActionListener listen)
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