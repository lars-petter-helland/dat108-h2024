/*
 * En helt plain Java-klasse (-Bean)
 * Brukes for å demonstrere objekt -> JSON.
 */
package no.hvl.dat108;

public class Hilsen {

	String navn;
	String hilsetekst = "Hei på deg, ";
	
	public Hilsen(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public String getHilsetekst() {
		return hilsetekst;
	}
	
	
}
