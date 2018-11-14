package hbs.database;

import hbs.Models.BookingModel;
import hbs.Models.GuestModel;
import hbs.Models.UserModel;

public class BookingDBController {
	DatabaseHelper dbHelper;
	public BookingDBController() {
		dbHelper = DatabaseHelper.getInstance();
	}
	private GuestModel guest = new GuestModel();
	private BookingModel booking = new BookingModel();
	public GuestModel newGuest(String fName,String lName) {
		String resultSet = "";
		int gID = 0;
		String first_name = null;
		String last_name = null;
		String memSince = null;
		int totalSpent = 0;
		int memLev = 0;
		guest = null;
		//dud call to db
		resultSet = executeQuery("SELECT from Guests WHERE first_name = '" + fName + "' AND last_name = '" + lName + "'");
		//the following is a mock up of the implementation.
		if(nameValidation(fName,lName)) {
			gID = 101;
			first_name = "Vera";
			last_name = "Oscar";
			memSince = "2010";
			totalSpent = 2000;
			memLev = 4;
			guest = new GuestModel(gID,first_name,last_name,memSince,totalSpent,memLev);
		}
			return guest;	
	}
	public BookingModel bookingDates(String dateIn,String dateOut) {
		String resultSet = "";
		int gID = 0;
		String date_in = null;
		String date_out = null;
		if(dateValidation(dateIn,dateOut)) {
			gID = guest.getGID();
			date_in = "01/06/2019";
			date_out = "20/06/2019";
			booking = new BookingModel(gID,date_in,date_out);
		}
		return booking;
	}
	
	public boolean dateValidation(String dateIn, String dateOut) {
		//to do date validation.
		return true;
	}

	public boolean nameValidation(String fName, String lName) {
		if(fName.equals("Vera") && lName.equals("Oscar")) {
			return true;
		}else {
			return false;
		}

	}

	private String executeQuery(String query) {
		//Dud call to db
				dbHelper.executeQuery(query);
				//String represents the return value from db query.
				String resultSet = "result";
				return resultSet;
	}
}
