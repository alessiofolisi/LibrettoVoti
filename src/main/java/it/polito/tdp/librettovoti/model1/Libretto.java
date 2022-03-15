package it.polito.tdp.librettovoti.model1;

import java.util.*;

public class Libretto {

	private List<Voto> voti;


	public Libretto() {
		
		this.voti = new ArrayList<Voto>();
		
	}
	
	public void add(Voto v){
		if(!isDuplicato(v) && !isConflitto(v)) this.voti.add(v);
	}
	
	public String toString() {
		
		return this.voti.toString();
	}
		
	public Libretto filtraPunteggio(int punti){
		
		Libretto result = new Libretto();
		
		for(Voto v : this.voti) {
			if(v.getPunteggio() == punti) {
				
				result.add(v);
				
			}
		}
		
		return result;
	}
	
	public Integer getPunteggio(String corso){
		int voto = -1;
		
		for(Voto v : this.voti) {
		if(v.getCorso().compareTo(corso)==0) 
		voto = v.getPunteggio();	
		}
		
		if(voto==-1) return null;
		else return voto;
	}
	
	public boolean isDuplicato(Voto v) {

		for(Voto v1 : this.voti) {
			if(v1.equals(v)) return true;
		}
		
		return false;
		}
	
	public boolean isConflitto(Voto v){
		
		Integer punti = this.getPunteggio(v.getCorso());
		
		if(punti != null && punti != v.getPunteggio()) return true;
		else 	return false;
	}
	
	public List<Voto> getVoti(){
		return this.voti;
	}

	public Libretto votiMigliorati() throws CorsoNonTrovato {
		Libretto nuovo = new Libretto();
		Voto v = null;
		for(Voto v1 : this.voti) {
			int punti = v1.getPunteggio();
			if(punti>=24) punti += 2;
			else punti++;
			if(punti>30) punti = 30;
			
			v = v1;
			v.setPunteggio(punti);
			
			nuovo.add(v1);
		}
		return nuovo;
	}

	
	public void rimuoviMinori(int punti) {
		for(Voto v : this.voti) {
			if(v.getPunteggio()<punti) {
				this.voti.remove(v);
			}
		}
	}
}
