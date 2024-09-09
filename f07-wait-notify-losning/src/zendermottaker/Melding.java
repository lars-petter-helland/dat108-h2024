package zendermottaker;

public class Melding {
	
	private String tekst;
	private boolean meldingLest = true;

	public String getTekst() {
		meldingLest = true;
		return tekst;
	}

	public void setTekst(String tekst) {
		meldingLest = false;
		this.tekst = tekst;
	}
	
	public boolean erMeldingLest() {
		return meldingLest;
	}
}
