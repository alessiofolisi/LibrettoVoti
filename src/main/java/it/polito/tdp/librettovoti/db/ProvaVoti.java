package it.polito.tdp.librettovoti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class ProvaVoti {
	
	
	public void aggiungiVoto(String nome, int punti) {
	
		String url = "jdbc:mariadb://localhost:3306/libretto?user=root&password=root";
		try {
			Connection conn = DriverManager.getConnection(url);
			String sql = "INSERT INTO voti (nome, punti) VALUES (?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
		
			st.setString(1,nome);
			st.setInt(2, punti);
			
			int res = st.executeUpdate(sql);
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		
		ProvaVoti provaVoti = new ProvaVoti();
		provaVoti.aggiungiVoto("Economia Aziendale", 25);

		String url =  "jdbc:mariadb://localhost:3306/libretto?user=root&password=root";
		
		try {
			Connection conn = DriverManager.getConnection(url);
	
			Statement st = conn.createStatement();
			

			String sql = "SELECT * FROM Voti";
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				
				String nome = res.getString("nome");
				int voto = res.getInt("punti");
				System.out.println(nome + "" + voto);	
			}
			st.close();
			
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
