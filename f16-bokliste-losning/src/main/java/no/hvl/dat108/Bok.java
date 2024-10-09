package no.hvl.dat108;

public class Bok {
	
    private String tittel;
    private String forfatter;
    private int utgivelsesaar;

    public Bok(String tittel, String forfatter, int utgivelsesaar) {
        this.tittel = tittel;
        this.forfatter = forfatter;
        this.utgivelsesaar = utgivelsesaar;
    }

	public String getTittel() {
		return tittel;
	}

	public String getForfatter() {
		return forfatter;
	}

	public int getUtgivelsesaar() {
		return utgivelsesaar;
	}

	@Override
	public String toString() {
		return "Bok [tittel=" + tittel + ", forfatter=" + forfatter 
				+ ", utgivelsesaar=" + utgivelsesaar + "]";
	}

	
}
