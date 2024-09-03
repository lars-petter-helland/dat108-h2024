package no.hvl.dat108.f06c;

public class TraadSomKanStoppes extends Thread {
	
	//1: Ha et internt "flagg" som det sjekket på "jevnlig"
	boolean fortsette = true;

	//2: Ha mulighet til å be tråden om å stoppe
	public void stopp() {
		fortsette = false;
	}
	
	public TraadSomKanStoppes(String navn) {
		super(navn);
	}
	
	//
	@Override
	public void run() {
		while(fortsette) { //3: Fullføre run() på en kontrollert måte!
			System.out.println("Hei");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println(getName() + " avsluttes");
	}
}




