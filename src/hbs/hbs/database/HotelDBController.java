package hbs.database;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


import hbs.Models.HotelModel;

public class HotelDBController {
    private List<HotelModel> hotels;
    private HotelModel model;

    
    public void HotelDBCotroller() {
	hotels = new ArrayList<>();
	model = new HotelModel();
	
	for(int i = 0; i<=11;i++)
	{
	    hotels.add(new HotelModel(i,model.getHID(),model.getCountry(),model.getCity(),model.getName(),model.getRooms()));
	}
    }
    /*
     * @return a list of hotels
     */
    public List<HotelModel> getHotels(){
	return this.hotels;
    }
    
    /*
     * @param hotelId The ID for the hotel
     * @return hotel object
     */
    public HotelModel getHotel( int hID)
    {
	return ((HotelModel) hotels).filter(h -> h.getHID() == hID).collect(Collectors.toList()).get(0);
    }
    
    public void decrementHotelsRooms(int hID,int rooms)
    {
	if(model.getHID() == hID)
	   int numRooms = model.getRooms();
	   numRooms -= rooms;
	   model.setRooms(numRooms)
	}
	
    }
}