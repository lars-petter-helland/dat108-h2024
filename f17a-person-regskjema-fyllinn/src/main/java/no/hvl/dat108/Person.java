package no.hvl.dat108;

public class Person {
	
	private String fornavn;
	private String etternavn;
	private int fodselsaar;
	
	public Person(String fornavn, String etternavn, int fodselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodselsaar = fodselsaar;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public int getFodselsaar() {
		return fodselsaar;
	}

	@Override
	public String toString() {
		return "Person [fornavn=" + fornavn + ", etternavn=" + etternavn 
				+ ", fodselsaar=" + fodselsaar + "]";
	}
	
	

	
}
