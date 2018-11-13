package hbs.interfaces;

import java.util.Date;

public interface IBookable {

	public double getPricePerNight();
	public Date availableFrom();
	public Date availableTo();
}