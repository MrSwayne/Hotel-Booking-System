package hbs.lambda;

import java.util.Map;

public interface CustomerBookingHandler {
    /*
     *This method should validate the input given to us for booking 
     */
    public void validateInput(Map<String,Object> input) throws RuntimeException;
    /*
     * This method should response if the inmpuit is correct or not 
     */
    public Map<String,Object> generateResponse(Map<String,Object> input);
	Map<String, Object> handleBooking(Map<String, Object> input);
}
