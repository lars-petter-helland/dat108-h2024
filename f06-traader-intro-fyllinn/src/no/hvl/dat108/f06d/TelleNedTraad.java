package no.hvl.dat108.f06d;

public class TelleNedTraad extends Thread {

	private Teller teller;
	private int n;
	
	public TelleNedTraad(Teller teller, int n) {
		this.teller = teller;
		this.n = n;
	}
	
	@Override
	public void run() {
		for (int i=0; i<n; i++) {
			teller.tellNed();
		}
	}
}
