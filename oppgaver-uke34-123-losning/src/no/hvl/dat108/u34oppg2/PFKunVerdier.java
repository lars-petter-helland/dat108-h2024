package no.hvl.dat108.u34oppg2;

public class PFKunVerdier implements Personformat {

	@Override
	public String somStreng(Person p) {
		return p.fornavn() + " " + p.etternavn() + " " + p.fodselsaar() + " " + p.mobil();
	}

}
