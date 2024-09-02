package no.hvl.dat108.f05;

import static no.hvl.dat108.f05.People.people;

public class Eks2countmatch {

	public static void main(String[] args) {

		//Alle forbokstavene i fornavnene i en streng "CLTCM" - reduce() 
		String forboks = people.stream()
				.map(p -> "" + p.firstName().charAt(0))
				.reduce("", String::concat); //concat i stedet for +
		System.out.println(forboks);
		
		//Antall personer over 50 år - count()
		long antallOver50 = people.stream()
				.filter(p -> p.age() > 50)
				.count();
		System.out.println(antallOver50);
		
		//Om vi har data som matcher
		//	anyMatch(pred), allMatch(pred), noneMatch(pred)
		
		//Er alle over 30 år?
		boolean alleOver30 = people.stream()
				.allMatch(p -> p.age() > 30);
		System.out.println(alleOver30);
		
		//Er noen over 60 år?
		boolean noenOver60 = people.stream()
				.anyMatch(p -> p.age() > 60);
		System.out.println(noenOver60);
	}
}




