package no.hvl.dat108.oppg5filmer;

public class Film {
	private final String tittel;
	private final String regissor;
	private final int utgivelsesaar;
	private final double imdbRating;
	
	public Film(String tittel, String regissor, 
			int utgivelsesaar, double imdbRating) {
		this.tittel = tittel;
		this.regissor = regissor;
		this.utgivelsesaar = utgivelsesaar;
		this.imdbRating = imdbRating;
	}

	public String getTittel() {
		return tittel;
	}

	public String getRegissor() {
		return regissor;
	}

	public int getUtgivelsesaar() {
		return utgivelsesaar;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	@Override
	public String toString() {
		return "Film [tittel=" + tittel + ", regissor=" 
				+ regissor + ", utgivelsesaar=" + utgivelsesaar
				+ ", imdbRating=" + imdbRating + "]";
	}
}
