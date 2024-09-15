package ex3_atomic;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		//Felles teller
		TellerAtomic teller = new TellerAtomic();
		
		Thread telleOppTraad = new TelleOppTraad(teller, 100_000);
		Thread telleNedTraad = new TelleNedTraad(teller, 100_000);
		
		telleOppTraad.start();
		telleNedTraad.start();
		
		telleOppTraad.join();
		telleNedTraad.join();
		
		System.out.println(teller.getVerdi());
		
	}

}
