package zendermottaker;

public class Main {

	public static void main(String[] args) {
		
		Melding melding = new Melding();
		
		Thread sender = new Sender(melding);
		Thread mottaker = new Mottaker(melding);
		
		sender.start();
		mottaker.start();
	}

}
