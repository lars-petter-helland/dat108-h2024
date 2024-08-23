package no.hvl.dat108.u34oppg2;

import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		List<Person> personer = List.of(
				new Person("Atle", "Patle", 1970, "32132321"),
				new Person("Per", "Viskeler", 1972, "44132321"),
				new Person("Madam", "Felle", 1960, "98132321"),
				new Person("Donald", "Duck", 1950, "88132321")
				);
		
		Personformat pf = new PFCapsUtenMobil();
		skrivUt(personer, pf);
	}

	private static void skrivUt(List<Person> personer, Personformat format) {
		for (Person p : personer) {
			System.out.println(format.somStreng(p));
		}
	}
}
