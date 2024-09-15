package fut3_CallableOgFuture;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public final static int N = 44;
	
	public static void main(String... kommandolinjeargumenter) 
			throws InterruptedException, ExecutionException {
		
		//Tidtaking
		Instant start = Instant.now();
		
		//Beregning ... Denne tar litt tid ... ønsker å kunne gjøre noe samtidig
		Callable<Long> fibCallable = new Callable<>() {
			@Override
			public Long call() throws Exception {
				return new Fibonacci().fib(N);
			}
		};
		
		//I stedet for å bruke en Thread kan vi bruke en ExecutorService.
		//Denne kan kjøre mange oppgaver i ulike tråder alt etter hvordan
		//vi setter ting opp. 
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Long> fibFremtidigResultat = executor.submit(fibCallable);
		
		while(!fibFremtidigResultat.isDone()) { //BUSY WAIT
			//Gjøre noe annet mens vi venter
			System.out.print(".");
			Thread.sleep(500);
		}
		executor.shutdown();
				
		//Tidtaking
		Instant ferdig = Instant.now();
		Duration tidsbruk = Duration.between(start, ferdig);
		
		//Utskrift
		System.out.println("\n\nfib(" + N + ")  = " + fibFremtidigResultat.get());
		System.out.println("Tidsbruk = " + tidsbruk.toMillis() + " ms");
	}
}
