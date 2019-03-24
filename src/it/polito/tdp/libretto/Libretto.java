package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti; //bisogna inizializzare le variabili più genericamente possibile

	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	public void add(int voto, String corso, LocalDate data) {
		
	}
	
	/*
	 * aggiunge un nuovo voto al libretto
	 * 
	 * @param v il {@link Voto} da aggiungere
	 */
	public void add(Voto v) {
		voti.add(v);
	}
	
	/*
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * 
	 * @param punti punteggio di ricerca
	 * @return lista {@link Voto} aventi quel punteggio (eventualmente vuota)
	 */
	
	public List<Voto> cercaVoti (int punti){
		List<Voto> result= new ArrayList<Voto>();
		
		for(Voto v: this.voti) {
			if(v.getPunti()==punti)
				result.add(v);
		}
		return result;
	}

}
