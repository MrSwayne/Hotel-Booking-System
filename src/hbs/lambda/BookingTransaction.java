package hbs.lambda;

import java.util.ArrayList;
import java.util.List;

import database.HotelDBControllerl;
import hbs.models.HotelModel;

public class BookingTransaction {
    
    public void handleTransactions(int hID,int rooms)
    {
	HotelDBController db = new HotelDBController();
	
	db.decremenentHotelRooms(hID,rooms);
	
	
    }
}
