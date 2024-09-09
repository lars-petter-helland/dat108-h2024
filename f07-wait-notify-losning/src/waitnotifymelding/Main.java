package waitnotifymelding;

public class Main {

	public static void main(String[] args) {

		Melding melding = new Melding();

		Thread printlnTraad = new Thread(() -> System.out.println(melding.getTekst()));
		Thread giVerdiTraad = new Thread(() -> melding.setTekst("Hallo"));

		printlnTraad.start();
		giVerdiTraad.start();
	}

}
