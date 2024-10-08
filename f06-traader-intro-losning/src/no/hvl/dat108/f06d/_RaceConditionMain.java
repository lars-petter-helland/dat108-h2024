package no.hvl.dat108.f06d;

public class _RaceConditionMain {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * I dette eksempelet skal vi se at vi må beskytte delte ressurser
		 * mot potensiell samtidig oppdatering fra flere tråder ...
		 * 
		 * Vi lar to tråder ha tilgang til et (og samme) Teller-objekt.
		 * Den ene tråden prøver å øke verdien, mens den andre prøver å redusere verdien
		 *
		 * Vi skal se hvordan dette går, og evt. hva som kan/må gjøres for å
		 * få en mer "kontrollert" utførelse.
		 */
		
		Teller teller = new Teller();
		Thread telleOpp = new TelleOppTraad(teller, 100_000);
		Thread telleNed = new TelleNedTraad(teller, 100_000);
		
		telleOpp.start();
		telleNed.start();
		
		telleOpp.join();
		telleNed.join();
		
		System.out.println("Teller = " + teller.getVerdi());
	}

}






