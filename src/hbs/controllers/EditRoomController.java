package hbs.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hbs.managers.EditRoomManager;
import hbs.views.EditRoomView;
import hbs.views.MainMenuView;
import hbs.views.View;
//import view and model.
public class EditRoomController extends Controller {
	public EditRoomController()
	{
	}
	@Override
	public void addObserver(View view)
	{
	    observers.add(view);
	    EditRoomView editRoomView = (EditRoomView) view;
	    EditRoomListener listener = new EditRoomListener(editRoomView); 
	    editRoomView.addEditRoomListener(listener);
	}
	
	@Override
	public void removeObserver(View view) {
	    observers.remove(view);
	}
	
	class EditRoomListener implements ActionListener{
		
		private EditRoomView view;
		
		public EditRoomListener(EditRoomView view) {
			this.view = view;
		}
	    
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
			try {
				EditRoomManager editRoomManager = new EditRoomManager();
				editRoomManager.checkInfo(view.getRoomNo(),view.getRoomType(),view.getStatus(),view.getPrice());	    
			} catch(Exception e) {
			    
			}
	    }
	    
	}

	@Override
	public void notifyObservers() {
	    MainMenuView menu = new MainMenuView();
	    menu.MainMenuView();
	}
}
