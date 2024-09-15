package ex3_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class TellerAtomic {

	/*
	 * Her bruker vi AtomicInteger i stedet for int / Integer.
	 * 
	 * Metodekall på AtomicInteger er "atomic", dvs. at de utføres
	 * i sin helhet i ett skritt, og det er ikke nødvendig å sette
	 * på synchronized for å gjøre de trådsikre! 
	 */
	private AtomicInteger verdi = new AtomicInteger();

	public void tellOpp() {
		verdi.incrementAndGet();
	}

	public void tellNed() {
		verdi.decrementAndGet();
	}

	public int getVerdi() {
		return verdi.get();
	}

}
