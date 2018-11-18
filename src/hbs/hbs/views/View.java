package hbs.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import hbs.controllers.Controller;

public abstract class View extends JFrame implements ActionListener {
	
	protected Controller controller;
	
	protected View() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);//setting to the center of the screen
		this.setVisible(true);
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void setMessage(String message) {
		//TODO
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
