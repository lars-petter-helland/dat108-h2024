package fut4_BedreInnpakking;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

	public final static int N = 44;
	
	public static void main(String... kommandolinjeargumenter) 
			throws InterruptedException, ExecutionException {
		
		//Tidtaking
		Instant start = Instant.now();

		Fibonacci fib = new Fibonacci();
		Future<Long> fibFremtidigResultat = fib.beregn(N);
		
		while(!fibFremtidigResultat.isDone()) { //BUSY WAIT
			//Gjøre noe annet mens vi venter
			System.out.print(".");
			Thread.sleep(500);
		}
		fib.shutDown();
				
		//Tidtaking
		Instant ferdig = Instant.now();
		Duration tidsbruk = Duration.between(start, ferdig);
		
		//Utskrift
		System.out.println("\n\nfib(" + N + ")  = " + fibFremtidigResultat.get());
		System.out.println("Tidsbruk = " + tidsbruk.toMillis() + " ms");
	}
}
