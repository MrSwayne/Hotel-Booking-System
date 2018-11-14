package hbs.Views;

import javax.swing.JOptionPane;

public class HotelSelectorView{
   
	public void HotelSelector()
	{
	    MainMenuView view = new MainMenuView();
	    String [] hotels = {"Hotel1","Hotel2","Hotel3","Hotel4","Hotel5","Hotel6","Hotel7","Hotel8"};
		String input = (String) JOptionPane.showInputDialog(null,"Choose Hotel","Hotel Selector",JOptionPane.QUESTION_MESSAGE,null,
				hotels,//Array of hotels
				hotels[0]);//Initial Choice  
		
		for(int i=0;i<hotels.length;i++)
		{
		    if(input.equalsIgnoreCase(hotels[i]))
		    {
			view.setVisible(true);
		    }
		}
		
	}
}