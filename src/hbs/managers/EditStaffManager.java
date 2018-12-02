package hbs.managers;


import hbs.controllers.EditStaffController;
import hbs.models.UserModel;

public class EditStaffManager{
    	private UserModel model = new UserModel();
    	private EditStaffController editStaffC = new EditStaffController();
	public EditStaffManager()
	{
	}

	public void checkInfo(String userID, String firstName, String lastName, String password, String wages)
	{
		int uNum = Integer.parseInt(userID);
	    model.setUID(uNum);
	    
	    if(model.checkUID()) 
	    {
	    	int wNum = Integer.parseInt(wages);
	    	
	    	model.setUserDetails(uNum,firstName,lastName,password,wNum);
	    	editStaffC.notifyObservers();
	    }

	}
}

