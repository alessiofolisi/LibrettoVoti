package it.polito.tdp.librettovoti.db;

import java.sql.*;
import java.util.*;

import it.polito.tdp.librettovoti.model1.Voto;

public class LibrettoDAO {
	
	
	public boolean createVoto(Voto v) {
		//FACCIO LA INSERT
		
		String url = "jdbc:mariadb://localhost:3306/libretto?user=root&password=root";

		try {
		Connection conn = DriverManager.getConnection(url);
		String sql = "INSERT INTO voti (nome, punti) VALUES (?, ?)";
		PreparedStatement st = conn.prepareStatement(sql);
	
		st.setString(1,v.getCorso());
		st.setInt(2, v.getPunteggio());
		
		int res = st.executeUpdate(sql);
		st.close();
		conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Voto> readAllVoto() {
		
		try {
			Connection conn = DBConnect.getConnection();
			String sql = "SELECT * FROM Voti";
			PreparedStatement st = conn.prepareStatement(sql);
		
			ResultSet res = st.executeQuery(sql);
			
			List<Voto> result = new LinkedList<Voto>();
			
			while(res.next()) {
				
				String nome = res.getString("nome");
				int punti = res.getInt("punti");
				result.add(new Voto(nome , punti));	
			}
			
			st.close();
			conn.close();
			return result;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}

	}
	
	public Voto readVotoByNome(String nome){
		
		return null;
	}
	

   
	
	
	
	
	
	

}
