package no.hvl.dat108.f05;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Eks6utviklere {
	
	public static void main(String[] args) throws Exception {
		
		List<Utvikler> utviklere = Arrays.asList(
				new Utvikler("Arne", Set.of("Java", "C")),
				new Utvikler("Pere", Set.of("Javascript", "C++")),
				new Utvikler("Knut", Set.of("Java")),
				new Utvikler("Anne", Set.of("Haskell", "C#", "Python")),
				new Utvikler("Emma", Set.of("Clojure", "Ruby", "C")),
				new Utvikler("Lise", Set.of("Java", "C")));

		System.out.println(
				"\nEn oversikt over hvilke utviklere som kan Java:");
		
		System.out.println(
				"\nNavnet på en utvikler som kan C#, eller \"INGEN\" om ingen kan C#:");

		System.out.println(
				"\nEn sortert liste over alle programmeringsspråkene utviklerne kan:");
		
		System.out.println(
				"\nHvilket språk flest utviklere kan (finner ett av dem):");
		//Vrien - Prøv selv ...
		
		//Hint1: Bruk flatMap, collect, groupingBy, identity og counting
		//       for å finne antall av hvert språk. Lagre dette i en variabel
		//		 av typen (Map<String, Long>).
		
		//Hint2: Bruk deretter max for å finne det språket flest utviklere kan.
		//       Husk at max returnerer en Optional. Og at en Map.Entry 
		//		 inneholder både key og value.
		
		System.out.println(
				"\nHvilke(t) språk flest utviklere kan hvis det er flere:");
		//Vrien - Prøv selv ...
		
		//Hint:  Bruk Map-et fra forrige oppgave, og filtrer ut de språkene
		//	     som har samme antall utviklere som det språket flest utviklere kan.


	}
}





