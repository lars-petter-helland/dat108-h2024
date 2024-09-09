package waitnotify;

public class Main {

	private static String melding;
	private static Object lock = new Object();
	
	public static void main(String[] args) {

		Thread printlnTraad = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					while (melding == null) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
						}
					}
				}
				System.out.println(melding);
			}
		});

		Thread giVerdiTraad = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(lock) {
					melding = "Hallo";
					lock.notifyAll();
				}
			}
		});

		printlnTraad.start();
		giVerdiTraad.start();
	}
}
