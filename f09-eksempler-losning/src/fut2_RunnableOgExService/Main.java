package fut2_RunnableOgExService;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public final static int N = 44;
	
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
		
		//I stedet for å bruke en Thread kan vi bruke en ExecutorService.
		//Denne kan kjøre mange oppgaver i ulike tråder alt etter hvordan
		//vi setter ting opp. 
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(fibRunnable);
		
		executor.shutdown();
		while(!executor.isTerminated()) { //BUSY WAIT
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
