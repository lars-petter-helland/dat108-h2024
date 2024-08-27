package no.hvl.dat108.oppg4betinget;

/* Oppgavetekst
 * 
 * Lars-Petter Helland, 25. august 2023
 * 
 * Her er en liten oppgave dere kan prøve selv til mandag for å se 
 * om dere har fått med dere hovedideen med lambda-uttrykk.
 * 
 * Oppgavetekst:
 * 
 * Lag en generell metode betingetUtskrift(...) som tar inn en streng 
 * og et (false | true) lambda-uttrykk og som skriver ut strengen kun 
 * hvis uttrykket er sant.
 * 
 * Lag en main(...)-metode som tester dette ut med et par ulike input, 
 * f.eks. krav om at stringen begynner på "X" eller at den er lengre 
 * enn 3 tegn.
 */

import java.util.List;

public class BetingetUtskrift {
	
	private static void betingetUtskrift(String s, Betingelse betingelse) {
		if (betingelse.erSannFor(s)) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		List<String> liste = List.of("X", "Hallo", "Per", "1234");
		
		for (String s : liste) {
			betingetUtskrift(s, x -> x.startsWith("X")); //Kun hvis streng starter med X
		}
		
		for (String s : liste) {
			betingetUtskrift(s, x -> x.length() > 3); //Kun hvis streng lengre enn 3
		}
	}
}

@FunctionalInterface
interface Betingelse {
	boolean erSannFor(String s);
}







