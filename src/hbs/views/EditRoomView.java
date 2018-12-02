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

public class EditRoomView extends View  
{
	JPanel mainPanel = new JPanel();
	private JTextField roomNo;
	private JTextField type;
	private JTextField status;
	private JTextField price;
	private JButton edit;
	
	public EditRoomView() 
	{
		this.setTitle("Edit Room");
		mainPanel = new JPanel(new GridLayout(4,1));
		
		JPanel roomNoPanel = new JPanel();
		JLabel roomNoLabel = new JLabel("Room No.: ",JLabel.CENTER);
		roomNo = new JTextField("",10);
		roomNoPanel.add(roomNoLabel);
		roomNoPanel.add(roomNo);
		
		JPanel typePanel = new JPanel();
		JLabel typeLabel = new JLabel("Type: ",JLabel.CENTER);
		type = new JTextField("",10);
		typePanel.add(typeLabel);
		typePanel.add(type);
		
		JPanel statusPanel = new JPanel();
		JLabel statusLabel = new JLabel("Status: ",JLabel.CENTER);
		status = new JTextField("",10);
		statusPanel.add(statusLabel);
		statusPanel.add(status);
		
		JPanel pricePanel = new JPanel();
		JLabel priceLabel = new JLabel("Price: ",JLabel.CENTER);
		price = new JTextField("",10);
		pricePanel.add(priceLabel);
		pricePanel.add(price);
		
		JPanel control = new JPanel();
		edit = new JButton("Edit");
		control.add(edit);
		
		mainPanel.add(roomNoPanel);
		mainPanel.add(typePanel);
		mainPanel.add(statusPanel);
		mainPanel.add(pricePanel);
		mainPanel.add(control);
		
		this.add(mainPanel);
		this.setVisible(true);
		this.pack();
	}
	
	public String getRoomNo() {
	    return roomNo.getText();
	}
	public String getRoomType() {
	    return type.getText();
	}
	public String getStatus() {
	    return status.getText();
	}
	public String getPrice() {
	    return price.getText();
	}
	
	public void addEditRoomListener(ActionListener listen)
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
	