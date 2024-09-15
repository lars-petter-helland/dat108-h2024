package fut6_CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

	public final static int N = 45;
	
	public static void main(String... kommandolinjeargumenter) 
			throws InterruptedException, ExecutionException {

		CompletableFuture<Void> futurePrint = CompletableFuture
				.supplyAsync(() -> Fibonacci.fib(N))
				.thenAccept(fib -> System.out.println("fib(" + N + ")  = " + fib));
		
		System.out.println("Hallo");
		
		futurePrint.get(); //Blocking
		
		System.out.println("Hallo");
	}
}
