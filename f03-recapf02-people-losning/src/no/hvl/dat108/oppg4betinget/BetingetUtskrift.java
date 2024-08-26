package no.hvl.dat108.oppg4betinget;

/* Lars-Petter Helland, 20. august 2024
 * 
 * Uke34 - Oppgave 4
 * 
 * Her er en liten oppgave dere kan prøve på labben og frem til 
 * mandag for å se om dere har fått med dere hovedideen med 
 * lambda-uttrykk.
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

public class BetingetUtskrift {
	
	private static void betingetUtskrift(String s, Betingelse b) {
		if (b.erOppfylt(s)) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		String tekst = "XH";
		betingetUtskrift(tekst, s -> s.startsWith("X")); //Begynner på "X"
		betingetUtskrift(tekst, s -> s.length() > 3); //Lengre enn 3 tegn
	}
}

@FunctionalInterface
interface Betingelse {
	boolean erOppfylt(String s);
}



