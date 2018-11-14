package hbs.Managers;


import hbs.Models.BookingModel;
import hbs.Models.GuestModel;
import hbs.Views.BookingView;
import hbs.database.BookingDBController;
import hbs.lambda.newBooking;
//import view and model.
public class BookingManager{
	private BookingView view;
	private BookingModel model;
	private GuestModel model2;
	private newBooking newBook;
	private BookingDBController db;

	public BookingManager(BookingView view)
	{
		this.view = view;
		model = new BookingModel();
		model2 = new GuestModel();
		newBook = new newBooking();
		db = new BookingDBController();
	}

	public void checkBooking(String fName,String lName,String date_in,String date_out,String roomsBooked,String type) {
		db.newGuest(fName, lName);
		if(db.nameValidation(fName, lName)) {
			db.bookingDates(date_in,date_out);
		}
	}
}