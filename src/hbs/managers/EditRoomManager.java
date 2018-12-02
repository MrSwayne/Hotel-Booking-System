package hbs.managers;


import hbs.controllers.EditRoomController;
import hbs.models.RoomModel;

public class EditRoomManager{
    	private RoomModel model = new RoomModel();
    	private EditRoomController editRoomC = new EditRoomController();
	public EditRoomManager()
	{
	}

	public void checkInfo(String roomNo, String type, String status, String price)
	{
		int rNum = Integer.parseInt(roomNo);
		model.setRoomNumber(rNum);
	    
	    if(model.checkRoomNo())
	    {
	    	int sNum = Integer.parseInt(status);
	    	int pNum = Integer.parseInt(price);
	    	model.setRoomDetails(rNum,type,sNum,pNum);
	    	editRoomC.notifyObservers();
	    }
	    else
	    {
	    	System.out.println("Room number doesn't exist");
	    }

	}
}

