package no.hvl.dat108.asortering;

/* 
 * For de late:
 * 
 * Ny mulighet f.o.m. Java16: record - En forenklet måte å lage en dataklasse.
 * 
 * Vi får da en fiks ferdig Person-klasse med:
 * - parametrisk konstruktør
 * - instansvariabler
 * - gettere
 * - toString
 * - equals og hashcode
 * */
public record Person(String fornavn, String etternavn, int fodselsaar)
	implements Comparable<Person> {

	/* Ønsker en litt forenklet toString(), så jeg omdefinerer denne */
	@Override
	public String toString() {
		return "["+ fornavn + ", " + etternavn + ", " + fodselsaar + "]";
	}

	/* Ønsker standard sortering på etternavn */
	@Override
	public int compareTo(Person other) {
		return this.etternavn().compareTo(other.etternavn());
	}
}


