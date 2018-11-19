package hbs.views;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class HotelSelectorView extends View{
   
	public HotelSelectorView()
	{
	    this.setTitle("Hotel Select");
	    String [] hotels = {"Hotel1","Hotel2","Hotel3","Hotel4","Hotel5","Hotel6","Hotel7","Hotel8"};
	    JComboBox hotelList = new JComboBox(hotels);
	    hotelList.setSelectedIndex(0);
	}

	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		
	}
}