package zendermottaker;

import javax.swing.JOptionPane;

public class Sender extends Thread {
	
	private Melding melding;

	public Sender(Melding melding) {
		this.melding = melding;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			String nyTekst = JOptionPane.showInputDialog("Skriv inn tekst:");
			
			synchronized(melding) {
				while(!melding.erMeldingLest()) {
					try {
						melding.wait();
					} catch (InterruptedException e) {
					}
				}
				melding.setTekst(nyTekst);
				melding.notifyAll();
			}
			System.out.println("Sender har sendt meldingen " + nyTekst);
		}
	}
	

}
