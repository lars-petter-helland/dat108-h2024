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
 * operations på streams.
 * 
 * Løsningene i dette eksempelet ble generert med GitHub Copilot
 * "live" i timen. Løsningene ble like til det jeg ville skrevet selv.
 * Kun småjusteringer ble gjort.
 */

public class Eksempel7 {
	
	public static void main(String[] args) {
		
		//a) Skrive ut alle partall i området [1,10>
		System.out.println("\nAlle partall i området [1,10>");
		IntStream.range(1, 10)
			.filter(i -> i % 2 == 0)
			.forEach(System.out::println);
		
		//b) Skrive ut kvadratet av alle tallene området [1,10>
		System.out.println("\nKvadratet av alle tallene området [1,10>");
		IntStream.range(1, 10)
            .map(i -> i * i)
            .forEach(System.out::println);
		
		//c) For en strøm av tallene 100, 103, 106, 109, ...
		//   skriv ut de 10 første som er delelig med 4
		System.out.println("\nDe 10 første i (100, 103, 106, ...) som er delelig med 4");
		Stream.iterate(100, i -> i + 3)
				.filter(i -> i % 4 == 0)
				.limit(10)
				.forEach(System.out::println);
		
		//d) For en stream av strenger, samle dem opp i en ny string, sortert
		//	 og uten duplikater. Skriv deretter ut resultatet.
		System.out.println("\nSorterte strenger uten duplikater");
		String resultat = Stream.of("b", "a", "c", "a", "b")
				.distinct()
				.sorted()
				.collect(Collectors.joining(", "));
		System.out.println(resultat);
		
		//e) For en stream av strenger, samle dem sortert på stringlengde, 
		//	 uten duplikater i en ny liste. Skriv deretter ut listen.
		System.out.println("\nSorterte strenger uten duplikater");
		List<String> favoritter = Stream.of("Java", "C++", "Java", "Python", "C++", "Haskell", "Java")
				.distinct()
				.sorted(Comparator.comparing(String::length))
				.toList();
		System.out.println(favoritter);
		
	}
}



