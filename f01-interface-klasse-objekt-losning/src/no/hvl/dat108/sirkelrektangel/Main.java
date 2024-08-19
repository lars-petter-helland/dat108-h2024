package no.hvl.dat108.sirkelrektangel;

/*
 * I dette eksemplet ser vi hvordan vi definerer et interface (en kontrakt),
 * Flate med metoden areal(), og at vi definerer flere klasser, Sirkel og 
 * Rektangel som begge er flater.
 * 
 * I programmet ser vi at f.eks. kan ha en tabell med ulike flater, dvs.
 * sirkler og rektangler, og at vi ikke trenger å vite hvilken type det
 * er i hvert enkelt tilfelle for å kunne bruke metoden areal().
 */
public class Main {
	
	public static void main(String[] args) {
		
		// Referansevariabelen s1 kan være av typen Sirkel
		Sirkel s1 = new Sirkel(1.0);
		System.out.println(s1.areal());
		
		// Referansevariabelen kan også være av typen Flate, siden
		// en Sirkel er en Flate.
		Flate f1 = new Sirkel(2.0);
		System.out.println(f1.areal());
		
		// Vi kan lagre alle typer flater i samme tabell 
		Flate[] flater = {
				s1,
				f1,
				new Rektangel(2.0, 3.5)
		};
		
		// Vi kan bruke areal()-metoden uten å vite hvilken type 
		// flate det er.
		for (Flate f : flater) {
			System.out.println(f.areal());
		}
	}
}
