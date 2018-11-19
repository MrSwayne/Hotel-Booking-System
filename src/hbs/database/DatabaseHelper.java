package hbs.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class DatabaseHelper {
	
	private Connection conn = null;
	
	private final String host = "localhost";
	private final String database = "hbs";
	private final String username = "root";
	private final String password = "";
	
	private String url = "jdbc:mysql://" + host + "/" + database + "?" + "user=" + username + "&password=" + password;
	
	
	private String uName;
	private String pWord;
	private String ip;
	
	private static DatabaseHelper instance = null;
	
	private DatabaseHelper() {
	}
	
	public static DatabaseHelper getInstance() {
		if(instance == null)
			instance = new DatabaseHelper();
		return instance;
	}
	
	private Connection conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(url, uName, pWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//Gets data from database and returns as a hashmap
	public HashMap<String, String> executeQuery(String sql) {
		
		//TODO
		// Convert result of sql query to hashmap
		HashMap<String,String> map = new HashMap<String, String>();
		return map;
	}
}
