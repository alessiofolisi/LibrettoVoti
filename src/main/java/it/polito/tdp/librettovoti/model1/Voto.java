package it.polito.tdp.librettovoti.model1;

import java.util.Objects;

public class Voto {

	
	private String corso;
	private int punteggio;
	
	public Voto(String corso, int punteggio) {
		this.corso = corso;
		this.punteggio = punteggio;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	@Override
	public String toString() {
		
		return corso + ": " + punteggio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(corso, punteggio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		return Objects.equals(corso, other.corso) && punteggio == other.punteggio;
	}
	

	
	

}
