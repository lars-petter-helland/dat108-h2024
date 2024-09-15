package fut5_FlereFibsSamtidig;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

	public static void main(String... kommandolinjeargumenter) 
			throws InterruptedException, ExecutionException {
		
		//Tidtaking
		Instant start = Instant.now();

		Fibonacci fib = new Fibonacci();
		Future<Long> fib44 = fib.beregn(44);
		Future<Long> fib30 = fib.beregn(30);
		Future<Long> fib42 = fib.beregn(42);
		Future<Long> fib10 = fib.beregn(10);
		Future<Long> fib44endaEnGang = fib.beregn(44);
		
		while(!(fib44.isDone() && fib30.isDone() && fib42.isDone() 
				&& fib10.isDone() && fib44endaEnGang.isDone())) { //BUSY WAIT
			//Gjøre noe annet mens vi venter
			System.out.print(".");
			Thread.sleep(500);
		}
		fib.shutDown();
				
		//Tidtaking
		Instant ferdig = Instant.now();
		Duration tidsbruk = Duration.between(start, ferdig);
		
		//Utskrift
		System.out.println("\n\nfib(10)  = " + fib10.get());
		System.out.println("fib(30)  = " + fib30.get());
		System.out.println("fib(42)  = " + fib42.get());
		System.out.println("fib(44)  = " + fib44.get());
		System.out.println("fib(44)  = " + fib44endaEnGang.get());
		System.out.println("Tidsbruk = " + tidsbruk.toMillis() + " ms");
	}
}
