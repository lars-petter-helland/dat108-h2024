package no.hvl.dat108;

public class Bok {
	
    private String tittel;
    private String forfatter;
    private int utgivelsesaar;
    private String genre;


	public Bok(String tittel, String forfatter, int utgivelsesaar, String genre) {
		this.tittel = tittel;
		this.forfatter = forfatter;
		this.utgivelsesaar = utgivelsesaar;
		this.genre = genre;
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

	public String getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "Bok [tittel=" + tittel + ", forfatter=" + forfatter 
				+ ", utgivelsesaar=" + utgivelsesaar + ", genre=" + genre + "]";
	}

	
}
