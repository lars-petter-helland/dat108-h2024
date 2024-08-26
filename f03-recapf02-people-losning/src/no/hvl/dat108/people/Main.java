package no.hvl.dat108.people;

/* Kopiert fra javabrains.io sitt Java 8 Lambda Basics kurs */

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
	
	static void printAll(List<Person> liste) {
		printConditionally(liste, p -> true);
	}

	static void printLastNameStartsWithC(List<Person> liste) {
		System.out.println();
		for (Person p : liste) {
			if (p.lastName().startsWith("C")) {
				System.out.println(p);
			}
		}
	}
	
	static void printConditionally(List<Person> liste, Predicate<Person> bet) {
		System.out.println();
		for (Person p : liste) {
			if (bet.test(p)) {
				System.out.println(p);
			}
		}
	}
	
	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		// 1: Sorter personene på etternavn.
		people.sort((p1,p2) -> p1.lastName().compareTo(p2.lastName()));
		
		// 2: Skriv ut alle personene, én linje per person. 
		// 		Lag en egen hjelpemetode printAll(...) som gjør dette.
		printAll(people);
		
		// 3: Skriv ut alle personene som har etternavn som begynner på C.
		//		Lag en egen hjelpemetode printLastNameStartsWithC(...) som gjør dette.
		printLastNameStartsWithC(people);
		
		// 4: Skriv ut alle personene som har fornavn som begynner på C.
		//		Vi ser nå at det er tungvint å lage én utskriftsmetode per
		//      spesialtilfelle. Lag en generell hjelpemetode printConditionally(...)
		//		gjør jobben i stedet. Denne tar inn listen + et lambdauttrykk.
		printConditionally(people, p -> p.firstName().startsWith("C"));
		
		// 5: Skriv ut ALLE personene ved å bruke printConditionally(...)
		//OK
		
		// >>>> Tilbake til ppt for litt mer "teori" før vi gjør siste
		
		// 6: Skriv ut fornavn til alle over 50 år.
		//    	Lag en metode doConditionally(...)
		doConditionally(people, p -> p.age() > 50, 
				p -> System.out.println(p.firstName()));
	}

	static void doConditionally(List<Person> liste, 
			Predicate<Person> bet, Consumer<Person> consumer) {
		
		System.out.println();
		for (Person p : liste) {
			if (bet.test(p)) {
				consumer.accept(p);
			}
		}
	}

}
