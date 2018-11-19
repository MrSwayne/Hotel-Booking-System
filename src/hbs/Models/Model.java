package hbs.models;

public abstract class Model {
	
	private int id;
	
	protected Model() {
		this.id = -1;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	public int getID() {
		return id;
	}
}
