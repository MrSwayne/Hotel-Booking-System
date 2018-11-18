package hbs.controllers;

import java.util.ArrayList;
import hbs.Models.Model;

import hbs.Views.View;

public abstract class Controller {
	
	protected ArrayList<View> observers;
	protected Model model;
	
	protected Controller() {
		observers = new ArrayList<>();
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
	
	public void addObserver(View view) {
		observers.add(view);
	}
	
	public void removeObserver(View view) {
		observers.remove(view);
	}
	
	public void notifyObservers() {
		
	}
}
