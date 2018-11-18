package hbs.lambda;

import hbs.lambda.common.Keys;
import hbs.models.HotelModel;

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

	@Override
	public void validateInput(Map<String, Object> input) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> generateResponse(Map<String, Object> input) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
