package ex3_atomic;

public class TelleNedTraad extends Thread {

	private TellerAtomic teller;
	private int antallGanger;

	public TelleNedTraad(TellerAtomic teller, int antallGanger) {
		this.teller = teller;
		this.antallGanger = antallGanger;
	}

	@Override
	public void run() {
		for (int i = 0; i < antallGanger; i++) {
			// Kristisk seksjon
			teller.tellNed();
		}
	}
}
