package fut1_RunnableOgThread;

import java.time.Duration;
import java.time.Instant;

public class Main {

	public final static int N = 46;
	
	//"Global variabel" :(
	//Måtte flytte denne hit og gjøre den static for å kunne endre fra run() !! :(
	//Ikke helt bra. Pakke inn i Resultat-objekt osv... Begynner å bli knotete.
	public static long fibResultat = 0;
	
	public static void main(String... kommandolinjeargumenter) throws InterruptedException {
		
		//Tidtaking
		Instant start = Instant.now();
		
		//Beregning ... Denne tar litt tid ... ønsker å kunne gjøre noe samtidig
		Runnable fibRunnable = new Runnable() {
			@Override
			public void run() {
				fibResultat = new Fibonacci().fib(N);
			}
		};
		
		Thread fibTraad = new Thread(fibRunnable);
		fibTraad.start();
		
		while(fibResultat == 0) { //BUSY WAIT
			//Gjøre noe annet mens vi venter
			System.out.print(".");
			Thread.sleep(500);
		}
				
		//Tidtaking
		Instant ferdig = Instant.now();
		Duration tidsbruk = Duration.between(start, ferdig);
		
		//Utskrift
		System.out.println("\n\nfib(" + N + ")  = " + fibResultat);
		System.out.println("Tidsbruk = " + tidsbruk.toMillis() + " ms");
	}
}
