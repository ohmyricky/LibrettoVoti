package it.polito.tdp.libretto;

import java.time.LocalDate;

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
		
		
	}

}
