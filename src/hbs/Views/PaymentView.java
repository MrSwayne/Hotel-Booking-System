package hbs.views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class PaymentView extends JFrame implements ActionListener {

	private JTextField nameF;
	private JTextField cNumberF;
	private JTextField expiryF;
	private JTextField securityF;
	private JLabel errorMsg;
	
	private JButton payBttn;
	private JButton cancelBttn;
	
	public PaymentView() {
			JPanel container = new JPanel();
			container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
			nameF = new JTextField("", 15);
			cNumberF = new JTextField("", 15);
			expiryF = new JTextField("", 5);
			securityF = new JTextField("", 4);
		
			
			JPanel namePanel = new JPanel();
			namePanel.add(new JLabel("Name: "));
			namePanel.add(nameF);
			container.add(namePanel);
			
			JPanel numPanel = new JPanel();
			numPanel.add(new JLabel("cNumber: "));
			numPanel.add(cNumberF);
			container.add(numPanel);
			
			JPanel expiryPanel = new JPanel();
			expiryPanel.add(new JLabel("Expiry: "));
			expiryPanel.add(expiryF);
			container.add(expiryPanel);
			
			JPanel securityPanel = new JPanel();
			securityPanel.add(new JLabel("Security: "));
			securityPanel.add(securityF);
			container.add(securityPanel);
		
			JPanel controlPanel = new JPanel();
			payBttn = new JButton("Pay");
			cancelBttn = new JButton("Cancel");
			controlPanel.add(cancelBttn);
			controlPanel.add(payBttn);	
			container.add(controlPanel);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(600,200);
			
			this.add(container);
			this.setVisible(true);
			this.pack();
	}
	
	public String getName() {
		return nameF.getText();
	}
	
	public String getcNumber() {
		return cNumberF.getText();
	}
	
	public String getExpiry() {
		return expiryF.getText();
	}
	
	public String getSecurity() {
		return securityF.getText();
	}
	
	public void addPayListener(ActionListener listen) {
		payBttn.addActionListener(listen);
	}
	
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}