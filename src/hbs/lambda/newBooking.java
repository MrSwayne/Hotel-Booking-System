package hbs.lambda;

import hbs.lambda.common.Keys;
import hbs.Models.HotelModel;

import java.util.Map;

import hbs.database.HotelDBController;

public class newBooking implements CustomerBookingHandler {

    @Override
    public Map<String,Object> handleBooking(Map<String,Object> input){
	
	this.validateInput(input);
	
	return this.generateResponse(input);
    }
    
    public BookingTransaction bookingTransaction(Map<String,Object> t) {
	int hID = (int) t.get(Keys.HOTEL_ID);
	int numOfRooms =(int) t.get(Keys.ROOM_NUMBERS);
	
	return new BookingTransaction(hID,numOfRooms);
    }
    
}
