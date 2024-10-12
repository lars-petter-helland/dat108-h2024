package no.hvl.dat108.f11;

public class Konge {
	
	public static final Konge DEFAULT = new Konge("[Mangler data]", 0, 0, 0);  
	
	private static final String STD_BILDE = "https://upload.wikimedia.org" 
				+ "/wikipedia/commons/thumb/d/d1/Heraldic_crown_of_Norway.svg/" 
				+ "250px-Heraldic_crown_of_Norway.svg.png";
	
	private String navn;
	private int fodtAar;
	private int kongeFraAar;
	private int kongeTilAar;
	private String bilde;
	
	public Konge(String navn, int fodtAar, int kongeFraAar, int kongeTilAar) {
		this(navn, fodtAar, kongeFraAar, kongeTilAar, STD_BILDE);
	}

	public Konge(String navn, int fodtAar, int kongeFraAar, int kongeTilAar,
			String bilde) {
		this.navn = navn;
		this.fodtAar = fodtAar;
		this.kongeFraAar = kongeFraAar;
		this.kongeTilAar = kongeTilAar;
		this.bilde = bilde;
	}
	
	@Override
	public String toString() {
		return navn + ", født " + fodtAar + ", konge fra " + kongeFraAar 
				+ " til " + kongeTilAar;
	}

	public String getNavn() {
		return navn;
	}

	public int getFodtAar() {
		return fodtAar;
	}

	public int getKongeFraAar() {
		return kongeFraAar;
	}

	public int getKongeTilAar() {
		return kongeTilAar;
	}
	
	public String getBilde() {
		return bilde;
	}	
}
