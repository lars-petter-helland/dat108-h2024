package zendermottaker;

public class Mottaker extends Thread {
	
	private Melding melding;

	public Mottaker(Melding melding) {
		this.melding = melding;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				sleep(10_000);
			} catch (InterruptedException e) {
			}
			
			String mottattTekst;
			
			synchronized(melding) {
				while(melding.erMeldingLest()) {
					try {
						melding.wait();
					} catch (InterruptedException e) {
					}
				}
				mottattTekst = melding.getTekst();
				melding.notifyAll();
			}
			System.out.println("Mottaker har mottatt melding " + mottattTekst);
		}
	}

}
