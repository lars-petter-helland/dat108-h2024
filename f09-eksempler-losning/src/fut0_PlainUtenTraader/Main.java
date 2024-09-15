package fut0_PlainUtenTraader;

import java.time.Duration;
import java.time.Instant;

public class Main {

	public final static int N = 44;
	
	public static void main(String... kommandolinjeargumenter) {
		
		//Tidtaking
		Instant start = Instant.now();
		
		//Beregning
		long fibResultat = new Fibonacci().fib(N);
				
		//Tidtaking
		Instant ferdig = Instant.now();
		Duration tidsbruk = Duration.between(start, ferdig);
		
		//Utskrift
		System.out.println("fib(" + N + ")  = " + fibResultat);
		System.out.println("Tidsbruk = " + tidsbruk.toMillis() + " ms");
	}
}
