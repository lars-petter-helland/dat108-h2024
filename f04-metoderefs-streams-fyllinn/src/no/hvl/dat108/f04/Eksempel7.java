package no.hvl.dat108.f04;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Eksempel7 / Gjøre sammen i timen
 * 
 * Øve oss litt på litt flere grunnleggende 
 *  - source		IntStream.range(), Stream.iterate(), Stream.of()
 *  - intermediate	filter(), map(), limit(), distinct(), sorted()
 *  - terminal 		forEach(), collect(), toList()
 *  
 * operations på streams.
 */

public class Eksempel7 {
	
	public static void main(String[] args) {
		
		//a) Skrive ut alle partall i området [1,10>
		System.out.println("\n\nAlle partall i området [1,10>");
		
		//b) Skrive ut kvadratet av alle tallene området [1,10>
		System.out.println("\n\nKvadratet av alle tallene området [1,10>");
		
		//c) For en strøm av tallene 100, 103, 106, 109, ...
		//   skriv ut de 10 første som er delelig med 4
		System.out.println("\n\nDe 10 første i (100, 103, 106, ...) som er delelig med 4");
		
		//d) For en stream av strenger, samle dem opp i en ny string, sortert
		//og uten duplikater. Skriv deretter ut resultatet.
		System.out.println("\n\nSorterte strenger uten duplikater");
//		System.out.println(resultat);
		
		//e) For en stream av strenger, samle dem sortert på stringlengde, 
		//uten duplikater i en ny liste. Skriv deretter ut listen.
		System.out.println("\n\nSorterte strenger uten duplikater");
//		System.out.println(favoritter);
		
	}
}
