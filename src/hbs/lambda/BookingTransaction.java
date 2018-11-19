package hbs.lambda;

import java.util.ArrayList;
import java.util.List;

import hbs.database.HotelDBController;
import hbs.models.HotelModel;

public class BookingTransaction {
    
    public BookingTransaction(int hID, int numOfRooms) {
		// TODO Auto-generated constructor stub
	}

	public void handleTransactions(int hID,int rooms)
    {
	HotelDBController db = new HotelDBController();
	
	/*
	db.decrementHotelsRooms(hID,rooms);
	*/
	
    }
}
