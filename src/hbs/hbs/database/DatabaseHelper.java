package hbs.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class DatabaseHelper {
	
	private Connection conn = null;
	private String url = "jdbc:mysql://localhost:8080/hbs";
	private String uName;
	private String pWord;
	private String ip;
	
	private static DatabaseHelper instance = null;
	
	private DatabaseHelper() {
		uName = "root";
		pWord = "apple1";
		ip = "192.168.1.1";
	}
	
	public static DatabaseHelper getInstance() {
		if(instance == null)
			instance = new DatabaseHelper();
		return instance;
	}
	
	private Connection conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch(ClassNotFoundException e) {
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
		return null;
	}
}
