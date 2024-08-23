package no.hvl.dat108.u34oppg2;

public class PFFastKolonnebredde implements Personformat {

	@Override
	public String somStreng(Person p) {
		
		// https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Formatter.html#syntax
		// "%1$-10s" betyr at første parameter(%1$) skal venstrejusteres(-), være 10 plasser(10),
		// og være basert på toString() av parameterverdien(s).
		// Kunne alternativt (og kanskje bedre) brukt String.format på hele resultatet samlet.
		String fornavn = String.format("%1$-10s", p.fornavn());
		String etternavn = String.format("%1$-10s", p.etternavn());
		
		return fornavn + " " + etternavn + " " + p.fodselsaar() + " " + p.mobil();
	}

}
