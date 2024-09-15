package ex3_atomic;

public class TellerSyncInt {

	private int verdi = 0;

	public synchronized void tellOpp() {
		verdi++;
	}

	public synchronized void tellNed() {
		verdi--;
	}

	public int getVerdi() {
		return verdi;
	}

}
