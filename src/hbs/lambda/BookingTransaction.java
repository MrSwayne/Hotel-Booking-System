package hbs.lambda;

import java.util.ArrayList;
import java.util.List;

import hbs.database.HotelDBController;
import hbs.Models.HotelModel;

public class BookingTransaction {
    
    public void handleTransactions(int hID,int rooms)
    {
	HotelDBController db = new HotelDBController();
	
	db.decrementHotelsRooms(hID,rooms);
	
	
    }
}
