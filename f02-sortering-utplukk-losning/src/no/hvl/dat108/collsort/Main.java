package no.hvl.dat108.collsort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		//1. Sortere i "naturlig" rekkefølge i hht. String compareTo. OK
		List<String> listen = Arrays.asList("Hallo", "blabla", "knut", "Per");
		System.out.println("Original liste:     " + listen);
		
		Collections.sort(listen);
		System.out.println("Naturlig sortering: " + listen);
		
		/*
		 * På samme måte som vår egen sorter()-metode hadde et utgave med en ekstra
		 * Sammenligner-parameter, så har Java sin sort()-metode det.
		 * Den ekstra parameteren her er en Comparator med metoden int compare(a,b).
		 * 
		 * Vi kan da lage ulike lambda-uttrykk for Comparator-objekter for ulike
		 * sorteringer. Siden compare-metoden har to parametre og returnerer en int,
		 * må lambda-uttrykkene også være slik.
		 */
		
		//2. Sortere alfabetisk uavhengig av store og små bokstaver
		Collections.sort(listen, (a, b) -> a.toLowerCase().compareTo(b.toLowerCase()));
		System.out.println("Ignore case:        " + listen);
		
		//4. Sortere på lengden på strengene
		Collections.sort(listen, (s1,s2) -> s1.length() - s2.length());
		System.out.println("String-lengde:      " + listen);
		
		//5. Sortere på lengden synkende. Putte lambda-uttrykk inn i variabel.
		Comparator<String> lengdeSynkende = (s1,s2) -> s2.length() - s1.length();
		
		Collections.sort(listen, lengdeSynkende);
		System.out.println("Strlengde synkende: " + listen);
	}
}







