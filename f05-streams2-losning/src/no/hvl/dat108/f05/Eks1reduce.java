package no.hvl.dat108.f05;

import static no.hvl.dat108.f05.People.people;

public class Eks1reduce {
	
	public static void main(String[] args) {
		
		/* Summen av aldrene til personene i people-listen */
		
//		int sumAlder = people.stream()
//				.map(p -> p.age())
//				.reduce(0, (akku, x) -> akku + x);
		
//		int sumAlder = people.stream()
//				.map(p -> p.age())
//				.reduce(0, (akku, x) -> Integer.sum(akku, x));
		
//		int sumAlder = people.stream()
//				.map(Person::age)
//				.reduce(0, Integer::sum);
		
		int sumAlder = people.stream().mapToInt(Person::age).sum();
		
		System.out.println("Sum alder er " + sumAlder);
		
		/* En streng med alle initialene, "CD LC TC CB MA" */
		String inits = people.stream()
				.map(p -> "" + p.firstName().charAt(0) + p.lastName().charAt(0))
				.reduce("", (akku, s) -> akku  + s + " "); //collect like greit her
		System.out.println(inits);
	}	
}



