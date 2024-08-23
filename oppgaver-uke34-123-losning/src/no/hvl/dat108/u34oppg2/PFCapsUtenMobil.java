package no.hvl.dat108.u34oppg2;

public class PFCapsUtenMobil implements Personformat {

	@Override
	public String somStreng(Person p) {
		return p.fornavn().toUpperCase() + " " + p.etternavn().toUpperCase() 
				+ ", født i " + p.fodselsaar();
	}

}
