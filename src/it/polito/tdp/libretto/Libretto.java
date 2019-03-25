package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti; //bisogna inizializzare le variabili pi� genericamente possibile

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
	
	/**
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
	
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui � specificato il nome
	 * 
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente, oppure {@code null} se non esistente
	 */
	public Voto cercaEsame(String nomeEsame) {
		for(Voto v:this.voti) {
			if(v.getCorso().equals(nomeEsame)) {
				return v;
			}
		}
		return null;
	}
	
	/**
	 * DAto un {@link Voto}, determina se esiste gi� un voto con uguale
	 * corso ed uguale punteggio.
	 * 
	 * @param v
	 * @return {@code true}, se ha trovato un corso ed un punteggio uguali,
	 * 		   {@code false}, se non ha trovato il corso, oppure l'ha trovato con voto diverso
	 */
	public boolean esisteGiaVoto (Voto v) {
		Voto trovato= this.cercaEsame(v.getCorso());
		if(trovato==null)
			return false;
		if(trovato.getPunti()==v.getPunti()) {
			return true;
		} else {
			return false;
		}
	}
	

}
