package hbs.views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CheckView extends View {/**
     * 
     */
    private static final long serialVersionUID = 1L;

    JPanel mainPanel = new JPanel();
	private JTextField idField;
	private JButton checkIn;
	private JButton checkOut;
	public CheckView() {
		this.setTitle("Check IN OUT");
		mainPanel = new JPanel(new GridLayout(3,1));
		
		JPanel bookingID = new JPanel();
		JLabel idLabel = new JLabel("Booking ID: ",JLabel.CENTER);
		idField = new JTextField("",10);
		bookingID.add(idLabel);
		bookingID.add(idField);
		
		
		
		JPanel control = new JPanel();
		checkIn = new JButton("Check IN");
		checkOut = new JButton("Check OUT");
		control.add(checkIn);
		control.add(checkOut);
		
		mainPanel.add(bookingID);
		mainPanel.add(control);
		
		this.add(mainPanel);
		this.setVisible(true);
		this.pack();
	}
	
	public void addCheckListener(ActionListener listen)
	{
	    checkIn.addActionListener(listen);
	    //checkOut.addActionListener(listen);
	}
	
	@Override
	public void setMessage(String message) {
	    // TODO Auto-generated method stub
	    
	}
}
