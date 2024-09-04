package no.hvl.dat108.f06d;

public class Teller {

	private int verdi = 0;

    /*
     * Vi kan gjøre Teller trådsikker ved å beskytte alle kritiske
     * deler av koden med synchronized.
     * 
     * Alternativ1, på kodeblokk:
     * 	synchronized(this) {
     *  	verdi++;
     *  }
     * Alternativ2, på hele metoden:
     * 	public synchronized void tellOpp() {
     * 		verdi++;
     * 	}
     * .. og tilsvarende på tellNed()
     */

	public void tellOpp() {
		verdi++;
		// verdi++ er IKKE atomisk. ~ verdi = verdi + 1, som:
		// 		1. Henter eksisterende verdi
		//		2. Beregner ny verdi: verdi + 1
		//		3. Lagrer den nye verdien
	}
	
	public void tellNed() {
		verdi--;
	}

	public int getVerdi() {
		return verdi;
	}
}
