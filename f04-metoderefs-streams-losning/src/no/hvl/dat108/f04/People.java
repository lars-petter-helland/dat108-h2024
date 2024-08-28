package no.hvl.dat108.f04;

import java.util.Arrays;
import java.util.List;

/*
 * En liste av personer til bruk i alle eksemplene.
 * Så slipper vi å klippe og lime inn i hvert enkelt eksempel.
 * 
 * Kan være automatisk tilgjengelig via static import, slik:
 * 		import static no.hvl.dat108.f04.People.people;
 */
public class People {
	
	public static List<Person> people = Arrays.asList(
			new Person("Charles", "Dickens", 60),
			new Person("Lewis", "Carroll", 42),
			new Person("Thomas", "Carlyle", 51),
			new Person("Charlotte", "Bronte", 45),
			new Person("Matthew", "Arnold", 39));

}
