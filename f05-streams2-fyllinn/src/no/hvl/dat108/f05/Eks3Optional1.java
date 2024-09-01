package no.hvl.dat108.f05;

import java.util.List;
import java.util.Optional;

/*
 * Dette eksemplet viser hvordan Optional kan brukes til å erstatte
 * nullsjekker og unngå NullPointerException.
 */

public class Eks3Optional1 {

	public static void main(String[] args) {

		List<Integer> enListeAvTall = List.of(1, 2, 3, 10, 11, 12);
		
		/*
		 * Problemstilling: Finn minste tall større enn 10 i en liste av tall.
		 * Hvis det finnes et slikt tall, skriv det ut.
		 * Hvis ikke, skriv ut at ingen tall ble funnet.
		 */
		
		// ### Først uten bruk av Optional, altså "gamlemåten".
		
		Integer minste = null;
		for (int tall : enListeAvTall) {
			if (tall > 10 && (minste == null || tall < minste)) {
				minste = tall;
			}
		}
		System.out.print("Gamlemåten:   ");
		if (minste != null) {
			skrivUtResultat(enListeAvTall, minste);
		} else {
			skrivUtTomtResultat(enListeAvTall);
		}
			
		// ### Så med bruk av Optional. 
		//		Kan da bruke ifPresentOrElse(Consumer, Runnable) for å få samme resultat
		// 		Eller vi kan bruke andre metoder på Optional for å hente ut verdien.
		
//		Alternativ for primitive int:
//		OptionalInt optMinsteAlt = noenTall.stream()
//				.filter(tall -> tall > 10)
//				.min();
			
		Optional<Integer> optMinste = enListeAvTall.stream()
				.filter(tall -> tall > 10)
				.min(Integer::compare);

		System.out.print("Med Optional: ");
		optMinste.ifPresentOrElse(
				x -> skrivUtResultat(enListeAvTall, x), 	//Consumer
                () -> skrivUtTomtResultat(enListeAvTall));	//Runnable
		
		//Andre muligheter med Optional.
		
		System.out.println("\noptMinste.ifPresent(...)");
		optMinste.ifPresent(System.out::println);
		
		System.out.println("\noptMinste.orElse(0)");
		System.out.println(optMinste.orElse(0));

		System.out.println("\noptMinste.get()");
		//Vil kaste en java.util.NoSuchElementException siden empty
		System.out.println(optMinste.get()); 
		
//		System.out.println("\noptMinste.orElseThrow(...)");
//		System.out.println(optMinste.orElseThrow(() -> new RuntimeException()));
	}

	// Hjelpemetode for å skrive ut resultatet
	private static void skrivUtResultat(List<Integer> liste, int resultat) {
		System.out.println("Minste tall over 10 i " + liste + ": " + resultat);
	}

	// Hjelpemetode for å skrive ut at ingen tall ble funnet
	private static void skrivUtTomtResultat(List<Integer> liste) {
		System.out.println("Minste tall over 10 i " + liste + " ikke funnet!");
	}

}
