package busywait;

public class Main {
	
	public static String melding;
	
	public static void main(String[] args) {
		
		//En tråd som skriver ut melding på skjermen
		Thread printlnTraad = new Thread() {
			@Override
			public void run() {
				while (melding == null) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
					}
				}
				System.out.println(melding);
			}
		};
		
		//En tråd som gir melding en verdi
		Thread giVerdiTraad = new Thread(() -> melding = "Hallo");
		
		printlnTraad.start();
		giVerdiTraad.start();
	}
}
