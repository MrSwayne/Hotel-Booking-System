package hbs.database;

import hbs.Models.UserModel;

public class LoginDBController {
	DatabaseHelper dbHelper;
	public LoginDBController() {
		dbHelper = DatabaseHelper.getInstance();
	}
	
	public UserModel verifyLoginDetails(String name,String password) {
		String resultSet = "";
		String uID = null;
		String firstName = null;
		boolean isManager = false;
		String hID = null;
		UserModel user = null;
		//dud call to database
		resultSet = executeQuery("SELECT users WHERE FirstName = '"+name+"' AND'"
				+password+"'");
		//The following is a mock up of the implementation
		if(validation(name,password)) {
			uID = "easy";
			firstName = "Patryk";
			isManager = true;
			hID = "The Marczaks";
			user = new UserModel(uID,firstName,isManager,hID);
		}
		return user;
	}
	
	public boolean validation(String name,String password) {
		if(name.equals("Patryk") && password.equals("easy")) {
			return true;
		}else {
			return false;
		}
	}

	protected String executeQuery(String query) {
		//Dud call to db
		dbHelper.executeQuery(query);
		//String represents the return value from db query.
		String resultSet = "result";
		return resultSet;
	}
}
