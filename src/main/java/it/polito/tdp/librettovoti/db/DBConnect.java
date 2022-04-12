package it.polito.tdp.librettovoti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	
	public static Connection getConnection() {
		
		String url = "jdbc:mariadb://localhost:3306/libretto?user=root&password=root";
		
		try {
			Connection conn = DriverManager.getConnection(url);
			return conn;
		} catch (SQLException e) {
			System.out.println("ERRORE di connessione al server");
			e.printStackTrace();
			return null;
		}
	}
	
}
