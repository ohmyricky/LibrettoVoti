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
	
	/**
	 * aggiunge un nuovo voto al libretto
	 * 
	 * @param v il {@link Voto} da aggiungere
	 * @return {@code true} nel caso normale, {@code false} se non � riuscito ad aggiungere
	 */
	public boolean add(Voto v) {
		if(!this.esisteGiaVoto(v) && !this.votoConflitto(v)) {
			voti.add(v);
			return true;
		} else {
			return false;
		}
		
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
		
		Voto voto=new Voto(0, nomeEsame, null);
		int pos=this.voti.indexOf(voto);
		if(pos==-1)
			return null;
		else
			return this.voti.get(pos);
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
		int pos=this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else {
			return v.getPunti()==this.voti.get(pos).getPunti();
		}			
			
		/*Voto trovato= this.cercaEsame(v.getCorso());
		if(trovato==null)
			return false;
		if(trovato.getPunti()==v.getPunti()) {
			return true;
		} else {
			return false;
		}*/
	}
	
	/**
	 * MI dice se {@link Voto} {@code v} � in conflitto con uno dei esistenti.
	 * Se il voto non esiste, non c'� conflitto. Se esiste ed ha punteggio diverso, c'� conflitto.
	 * @param v
	 * @return {@code true} se il voto esiste ed ha un punteggio diverso,
	 * 		   {@code false} se il voto non esiste, oppure esiste ma ha lo stesso punteggio 
	 */
	public boolean votoConflitto (Voto v) {
		int pos=this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else {
			return v.getPunti()!=this.voti.get(pos).getPunti();
		}
	}
	
	public String toString() {
		return this.voti.toString();
	}
	
	public Libretto librettoMigliorato() {
		Libretto nuovo= new Libretto();
		for(Voto v:this.voti) {
			nuovo.add(v.clone()); //non add(v) perch� altrimenti riuserei gli stessi valori della lista, cos� invece ne faccio un clone
		}
		for(Voto v: nuovo.voti) {
			int punti=v.getPunti();
			if(punti<24)
				punti =punti+1;
			else if(punti<=28)
				punti=punti+2;
			v.setPunti(punti);
		}
		return nuovo;
	}
	
	public void cancellaVotiScarsi() {
		List cancellare=new ArrayList<Voto>();
		for(Voto v: voti) {
			if(v.getPunti()<24)
				cancellare.add(v);
		}
		this.voti.removeAll(cancellare);
	}

}
