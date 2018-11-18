package hbs.manager;

import hbs.views.BookingView;
import hbs.models.BookingModel;

public class BookingManager {

	private BookingView view;
	private BookingModel model;
	
	public BookingManager(BookingView view, BookingModel model) {
		this.view = view;
		this.model = model;
	}
	
	public boolean book() {
		
		return true;
	}
}
