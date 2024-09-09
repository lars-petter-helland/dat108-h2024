package waitnotifymelding;

public class Melding {

	private String tekst;

	public synchronized String getTekst() {
		while (!harTekst()) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		return tekst;
	}

	public synchronized void setTekst(String tekst) {
		this.tekst = tekst;
		notifyAll();
	}

	public synchronized boolean harTekst() {
		return tekst != null;
	}
}
