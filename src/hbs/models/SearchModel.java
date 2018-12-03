package hbs.models;

import hbs.database.DatabaseHelper;

public class SearchModel extends Model
{
	private String firstName, secondName;
	
	public SearchModel()
	{
		
	}
	
	public void search()
	{
		DatabaseHelper db= DatabaseHelper.getInstance();
		Query query= db.executeQuery("select * from guests");
	}
	
	
	
}
