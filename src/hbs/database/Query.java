package hbs.database;

import java.util.ArrayList;
import java.util.Map;

public class Query extends ArrayList<Row> {
	
	private ArrayList<Row> rows;
	
	public Query() {
		rows = new ArrayList<Row>();
	}
	
	public String toString() {
		String line = "";
		for(int i = 0;i < this.size(); i++) {
			line+= this.get(i).toString() + "\n";
		}
		return line;
	}
}
