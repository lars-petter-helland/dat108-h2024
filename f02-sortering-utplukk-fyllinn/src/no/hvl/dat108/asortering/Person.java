package no.hvl.dat108.asortering;

/* Ny mulighet f.o.m. Java16: record - En forenklet måte å lage en dataklasse */
public record Person(String fornavn, String etternavn, int fodselsaar) {

	/* Ønsker en litt forenklet toString() */
	@Override
	public String toString() {
		return "["+ fornavn + ", " + etternavn + ", " + fodselsaar + "]";
	}
	
	/* Ønsker standard sortering på etternavn */
}


