package hbs.interfaces;

import hbs.interfaces.IBookable;

public interface IRoom extends IBookable  {
	public double getPricePerNight();
	public int getOccupancy();
}