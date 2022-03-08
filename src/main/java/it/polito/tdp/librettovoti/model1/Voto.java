package it.polito.tdp.librettovoti.model1;

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

}
