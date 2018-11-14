package hbs.factory;

import hbs.interfaces.IRoom;
import java.util.Date;

public class DoubleRoom implements IRoom {

	private double pricePerNight;
	private Date availableFrom;
	private Date availableTo;
	private int occupancy;

	//TODO
	@Override
	public double getPricePerNight() {
		return pricePerNight;
	}

	@Override
	public double getOccupancy() {
		return occupancy;
	}

	@Override
	public Date availableFrom() {
		return availableFrom;
	}

	public Date availableTo() {
		return availableTo;
	}
}