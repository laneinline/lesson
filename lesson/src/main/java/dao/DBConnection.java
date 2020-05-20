package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	//jdbc:postgresql://localhost:5432/lesson
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql:lesson";
	private static final String DB_USERNAME = "user1";
	private static final String DB_PASSWORD= "123456qqq";
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.println("Connection established.");
		} catch (ClassNotFoundException e ) {
			
			e.printStackTrace();
			System.out.println("Connection Db_driver resolve to class name error. ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection not established error. ");
		}
		return connection;
	}
}
