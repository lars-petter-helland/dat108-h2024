package no.hvl.dat108.f06a;

public class _OppretteTraaderMain {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * Det er to hovedmåter å opprette en tråd i Java (extends Thread 
		 * og implements Runnable), og 5 "varianter" med disse som er vanlige:
		 * 
		 * 	#1 - extends Thread der vår subklasse er en konkret (navngitt) klasse
		 *  #2 - extends Thread der vår subklasse er en anonym indre (navnløs) klasse
		 *  #3 - implements Runnable der vår impl-klasse er en konkret (navngitt) klasse
		 *  #4 - implements Runnable der vår impl-klasse er en anonym indre (navnløs) klasse
		 *  #5 - der et Runnable-objekt er definert som et lambda-uttrykk. 
		 *  	 Runnable er et @FunctionalInterface med én metode void run()
		 */

		// #1
		Thread t1 = new MinTraad();

		// #2
		Thread t2 = new Thread() {
			@Override
			public void run() {
				System.out.println("Hallo fra anonym Thread");
			}
		};

		// #3
		Thread t3 = new Thread(new MinRunnable());

		// #4
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hallo fra anonym Runnable");
			}
		});

		// #5
		Thread t5 = new Thread(() -> System.out.println("Hallo fra lambda Runnable"));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		// Main-tråden vil også si hallo
		System.out.println("Hallo fra main");
	}

}
