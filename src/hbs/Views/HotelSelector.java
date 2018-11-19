package hbs.views;

import javax.swing.JOptionPane;
public class HotelSelector {
	public static void main(String[] args)
	{
		String [] hotels = {"Hotel1","Hotel2","Hotel3","Hotel4","Hotel5","Hotel6","Hotel7","Hotel8"};
		String input = (String) JOptionPane.showInputDialog(null,"Choose Hotel","Hotel Selector",JOptionPane.QUESTION_MESSAGE,null,
				hotels,//Array of hotels
				hotels[1]);//Initial Choice
	}
}
