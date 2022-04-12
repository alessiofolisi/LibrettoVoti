package it.polito.tdp.librettovoti.model1;

import java.util.*;

import it.polito.tdp.librettovoti.db.LibrettoDAO;

public class Libretto {

	public Libretto() {	
	}
	
	public boolean add(Voto v){
		
		LibrettoDAO dao = new LibrettoDAO();
		boolean result = dao.createVoto(v);
		return result;
		
	}

	public List<Voto> getVoti(){
		LibrettoDAO dao = new LibrettoDAO();
		return dao.readAllVoto();
	}
	
}
		
	