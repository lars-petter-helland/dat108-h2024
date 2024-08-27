package no.hvl.dat108.oppg5filmer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String... blablabla) {
		List<Film> filmene = Arrays.asList(
			new Film("The Godfather", "Francis Ford Coppola", 1972, 9.1),
			new Film("The Dark Knight", "Christopher Nolan", 2008, 9.0),
			new Film("Pulp Fiction", "Quentin Tarantino", 1994, 8.9),
			new Film("Fight Club", "David Fincher", 1999, 8.8));
			// ...

/* Oppgavetekst */
		
/*   		a)	Sorter filmene alfabetisk på tittel ved å bruke 
  			Collections.sort(...) med Comparator. Lambda-uttrykket 
  			som representerer Comparatoren skrives direkte inn som 
 			parameter til sort(...). */
		
		Collections.sort(filmene, (a,b) -> a.getTittel().compareTo(b.getTittel()));
		
		System.out.println(); //Ikke en del av oppgaven, men greit å sjekke resultatet.
		filmene.forEach(System.out::println); 
  
/*		b)	Sorter filmene stigende på utgivelsesår ved å bruke 
			Collections.sort() med Comparator. Lambda-uttrykket som 
			representerer Comparatoren skal først defineres i en 
			variabel kalt paaUtgivelsesaar, og denne variabelen skal 
			deretter brukes som parameter til sort(...). */
		
		Comparator<Film> paaUtgivelsesaar = (a,b) -> a.getUtgivelsesaar() - b.getUtgivelsesaar();
		Collections.sort(filmene, paaUtgivelsesaar);
		
		System.out.println(); //Ikke en del av oppgaven, men greit å sjekke resultatet.
		filmene.forEach(System.out::println); 
	}

}
