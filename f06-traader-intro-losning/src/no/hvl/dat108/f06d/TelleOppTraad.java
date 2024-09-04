package no.hvl.dat108.f06d;

public class TelleOppTraad extends Thread {

	private Teller teller;
	private int n;

	public TelleOppTraad(Teller teller, int n) {
		this.teller = teller;
		this.n = n;
	}

	/*
	 * Hvis Teller ikke er trådsikker i seg selv, må vi bruke
	 * synchronized i alle trådene som gjør metodekall på teller.
	 * 
	 * Da er det synchronized på kodeblokk som gjelder, og vi
	 * holder "ballen" så kort tid som mulig slik at andre tråder
	 * slipper til.
	 */
	
	@Override
	public void run() {
		for (int i = 0; i < n; i++) {
			synchronized (teller) {
				teller.tellOpp();
			}
		}
	}
	
}
