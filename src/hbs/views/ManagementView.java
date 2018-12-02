package hbs.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManagementView extends View implements ActionListener 
{
    JPanel mainPanel = new JPanel();
    
    public ManagementView() {
	this.setTitle("Management");
	mainPanel = new JPanel(new GridLayout(2,1));
	
	JPanel control = new JPanel();
	control.setVisible(true);
	JButton btn1 = new JButton("Edit Rooms");
	btn1.setActionCommand("rooms");
	btn1.addActionListener(this);
	control.add(btn1);
	JButton btn2 = new JButton("Edit Staff");
	btn2.setActionCommand("staff");
	btn2.addActionListener(this);
	control.add(btn2);
	
	
	mainPanel.add(control);
	this.add(mainPanel);
	this.pack();
    }
    @Override
	public void actionPerformed(ActionEvent e) {

		String btnPressed = e.getActionCommand();
		if(btnPressed.equalsIgnoreCase("rooms"))
		{		
			this.remove(mainPanel);
			this.setVisible(false);
	    	EditRoomView roomView = new EditRoomView();
		}
		else if(btnPressed.equalsIgnoreCase("staff"))
		{
			this.remove(mainPanel);
			this.setVisible(false);
			EditStaffView staffView = new EditStaffView();
		}
    }
    
	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		
	}	
		

}
	