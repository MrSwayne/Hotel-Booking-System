package hbs.managers;


import hbs.models.BookingModel;
import hbs.models.GuestModel;
import hbs.views.BookingView;
//import view and model.
public class BookingManager{
	private BookingView view;
	private BookingModel model;
	private GuestModel model2;

	public BookingManager(BookingView view)
	{
		this.view = view;
		model = new BookingModel();
		model2 = new GuestModel();
	}

	public void checkBooking(String fName,String lName,String date_in,String date_out) {
		if(model.getDateIn().equals("")) {
			model.setDateIn(date_in);
		}else if(model.getDateOut().equals(""))
			model.setDateIn(date_out);
		else {
			//show error message that the rooms are taken....
		}
		
		if(fName == model2.getFirstName() && lName == model2.getLastName() )
		{
			// figure out the discount? or call payment view?
		}
		else
		{
			//create new customer account in the databse.
		}
	}
}