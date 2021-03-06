package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto libr=new Libretto();
		
		libr.add(new Voto(30, "Analisi 1",  LocalDate.of(2017, 1, 15)));
		libr.add(new Voto(21, "Analisi 2",  LocalDate.of(2018, 1, 25)));
		libr.add(new Voto(18, "Fisica 1",  LocalDate.of(2017, 6, 10)));
		libr.add(new Voto(28, "Fisica 2",  LocalDate.of(2018, 9, 3)));
		libr.add(new Voto(25, "Economia",  LocalDate.of(2018, 1, 28)));
		libr.add(new Voto(24, "Ricerca Operativa",  LocalDate.of(2018, 6, 24)));
		libr.add(new Voto(25, "Programmazione a oggetti",  LocalDate.of(2019, 2, 15)));
		libr.add(new Voto(27, "Geometria",  LocalDate.of(2017, 6, 15)));
		libr.add(new Voto(25, "Logistica",  LocalDate.of(2019, 1, 25)));
		libr.add(new Voto(20, "Elementi di economia",  LocalDate.of(2018, 6, 30)));
		
		
		List<Voto> venticinque= libr.cercaVoti(25);
		System.out.println(venticinque);
		
		Voto a1=libr.cercaEsame("Analisi 1");
		Voto a3=libr.cercaEsame("Analisi 3");
		System.out.println(a1);
		System.out.println(a3);
		
		Voto giusto= new Voto(27, "Geometria", LocalDate.now());
		Voto sbagliato= new Voto(28, "Geometria", LocalDate.now());
		Voto mancante= new Voto(30, "Merendine", LocalDate.now());
		System.out.format("Il voto %s � %s\n", giusto.toString(), libr.esisteGiaVoto(giusto));
		System.out.format("Il voto %s � %s\n", sbagliato.toString(), libr.esisteGiaVoto(sbagliato));
		System.out.format("Il voto %s � %s\n", mancante.toString(), libr.esisteGiaVoto(mancante));

		System.out.format("Il voto %s � in conflitto %s\n", giusto.toString(), libr.votoConflitto(giusto));
		System.out.format("Il voto %s � in conflitto %s\n", sbagliato.toString(), libr.votoConflitto(sbagliato));
		System.out.format("Il voto %s � in conflitto %s\n", mancante.toString(), libr.votoConflitto(mancante));
		
		System.out.println(libr.add(giusto));
		System.out.println(libr.add(sbagliato));
		System.out.println(libr.add(mancante));
		
		System.out.println(libr.toString());
		
		System.out.println("Libretto migliorato");
		Libretto migliore=libr.librettoMigliorato(); 
		System.out.println(libr.toString());
		System.out.println(migliore.toString());
		
		migliore.cancellaVotiScarsi();
		System.out.println(migliore.toString());
		
	}
	
	
	
	

}
