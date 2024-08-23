package no.hvl.dat108.u34oppg2;

/*
 * Se https://www.baeldung.com/java-record-keyword
 * 
 * Dette er en forenklet måte å lage en dataklasse på.
 * Vi får instansvariabler, parametrisk konstruktør,
 * gettere, toString, hashcode og equals ferdig servert.
 * 
 * Et objekt basert på en record er immutable.
 * 
 * Vi kan overskrive det vi ønsker endret, f.eks. om vi
 * ønsker en annen toString.
 */
public record Person(
		String fornavn, 
		String etternavn, 
		int fodselsaar, 
		String mobil) {
}
