package ex2_immutable;

public class Main2Immutable {

	public static void main(String[] args) {
		
		// Kan en MeldingImmutable deles og brukes av flere tråder samtidig?
		MeldingImmutable m = new MeldingImmutable("");
		
		String[] ordene1 = {"Hvordan", "går", "det", "Arne"};
		String[] ordene2 = {"How", "are", "you", "John"};
		
		new Thread(new ByggOgPrintHilsenB(m, ordene1)).start();
		new Thread(new ByggOgPrintHilsenB(m, ordene2)).start();
	}
}

class ByggOgPrintHilsenB implements Runnable {
	
	private MeldingImmutable m;
	private String[] ordene;
	
	public ByggOgPrintHilsenB(MeldingImmutable m, String[] ordene) {
		this.m = m;
		this.ordene = ordene;
	}

	@Override
	public void run() {
		for (String ord : ordene) {
			m = m.leggTil(ord + " "); // Muterer IKKE m
		}
		System.out.println(m);
	}
}


