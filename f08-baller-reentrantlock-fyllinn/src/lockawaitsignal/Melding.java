package lockawaitsignal;

public class Melding {

	private String tekst;

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public boolean harTekst() {
		return tekst != null;
	}
}
