package no.hvl.dat108.f02sortering;

import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		//1. Sortere liste av heltall. OK
		List<Integer> listeAvTall = Arrays.asList(4,2,7,5,9,1);
		Utvalgssortering.sorter(listeAvTall);
		System.out.println("Sortert listeAvTall: " + listeAvTall);
		
				
		//2. Sortere liste av strenger. OK
		List<String> listeAvString = Arrays.asList("Aaa", "Xxx", "Bbb", "Kkk");
		Utvalgssortering.sorter(listeAvString);
		System.out.println("Sortert listeAvString: " + listeAvString);
		
		
		//3. Sortere liste av personer på etternavn. OK. Bruker Person.compareTo().
		List<Person> listeAvPersoner = Arrays.asList(
				new Person("Anne", "Persen", 1985),
				new Person("Per", "Andersen", 1984),
				new Person("Knut", "Svensen", 1990));
		Utvalgssortering.sorter(listeAvPersoner);
		System.out.println("Sortert på etternavn: " + listeAvPersoner);
		
		
		//4. Ønsker å sortere på fornavn. Hva gjør vi?
		//   Jo vi utvider sorter() med en ekstra parameter, og så bruker vi logikken i 
		//   denne ekstra parameteren til å sammenligne, i stedet for å bruke Person.compareTo().
		//   Den ekstra parameteren er av type Sammenligner, med metoden sammenlign(a,b)
		//
		//   Vi kan da opprette et Sammenligner-objekt, f.eks. slik:
		//		Sammenligner<Person> fnsmnlgn = new Sammenligner<>() {
		//			@Override
		//			public int sammenlign(Person a, Person b) {
		//				return a.fornavn().compareTo(b.fornavn());
		//			}
		//		};
		//Eller som vi så senere, som et lambda-uttrykk, slik:
		Sammenligner<Person> fnsmnlgn = (a,b) -> a.fornavn().compareTo(b.fornavn());
		
		Utvalgssortering.sorter(listeAvPersoner, fnsmnlgn);
		System.out.println("Sortert på fornavn:   " + listeAvPersoner);
		
		//5. Ønsker å sortere på fødselsår. Hva gjør vi?
		//   Jo, tilsvarende til forrige:
		Sammenligner<Person> aarsmnlgn = (a,b) -> a.fodselsaar() - b.fodselsaar();
		
		Utvalgssortering.sorter(listeAvPersoner, aarsmnlgn);
		System.out.println("Sortert på fødselsår: " + listeAvPersoner);
	}
}

