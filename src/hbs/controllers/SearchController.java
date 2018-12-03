package hbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hbs.controllers.SearchController.SearchListener;
import hbs.managers.SearchManager;
import hbs.views.SearchView;
import hbs.views.MainMenuView;
import hbs.views.View;

public class SearchController extends Controller
{
	public SearchController()
	{
		
	}

	@Override
	public void addObserver(View view) {
		observers.add(view);
	    SearchView SearchView = (SearchView) view;
	    SearchListener listener = new SearchListener(searchView); 
	    searchView.addSearchListener(listener);
		
	}

	@Override
	public void removeObserver(View view) {
		observers.remove(view);
		
	}

	
class SearchListener implements ActionListener{
		
		private SearchView view;
		
		public SearchListener(SearchView view) {
			this.view = view;
		}
	    
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		try
		{
			SearchManager SearchManager = new SearchManager();
				    
		}
		catch(Exception e)
		{
		    
		}
	    }
	    
	}
	
	@Override
	public void notifyObservers() {
		MainMenuView menu = new MainMenuView();
	    menu.MainMenuView();
		
	}
	
}
