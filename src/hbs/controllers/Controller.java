package hbs.controllers;

import java.util.ArrayList;

import hbs.views.View;
import hbs.models.Model;

public abstract class Controller {
	
	protected ArrayList<View> observers;
	protected Model model;
	
	protected Controller() {
		observers = new ArrayList<>();
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
	
	public abstract void addObserver(View view);
	
	public abstract void removeObserver(View view);
	
	public abstract void notifyObservers();
}
