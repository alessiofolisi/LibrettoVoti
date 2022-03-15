package it.polito.tdp.librettovoti.model1;

public class TestLibretto {

	public static void main(String[] args) throws CorsoNonTrovato {
		
		Libretto lib = new Libretto();
		lib.add(new Voto("Analisi 1" , 30));
		lib.add(new Voto("Fisica 1" , 18));
		lib.add(new Voto("Informatica" , 25));
		lib.add(new Voto("Algebra Lineare" , 25));

		System.out.println(lib);
		
		System.out.println("Voti pari a 25:");
		Libretto lib25 = lib.filtraPunteggio(25);
		System.out.println(lib25);
		
		lib.getPunteggio("Analisi 1");
		System.out.println("Voto di Analisi 1:\n" + lib.getPunteggio("Analisi 1"));
		
		
		
	}

}
