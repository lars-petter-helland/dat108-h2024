package ex1_stateless;

public class MainStateful {

	public static void main(String[] args) {

		/*
		 * Begge trådene bruker samme kalkulator-objekt.
		 * Kalkulatoren har state (instansvariabler), og det er
		 * dette som er roten til at ting går galt i dette eksemplet.
		 */
		PriskalkulatorStateful kalk = new PriskalkulatorStateful();
		
		/*
		 * Trenger noen eksempeldata for å demonstrere problemstillingen.
		 * I "virkeligheten" hadde kanskje disse dataene oppstått i selve 
		 * trådene, men putter de inn i konstrukøren til Prisberegning-
		 * trådene for en enkel demo.
		 */
		Vare vare1 = new Vare(200, 5, 10);
		PrisberegningA beregning1 = new PrisberegningA(kalk, vare1);
		
		Vare vare2 = new Vare(300, 4, 50);
		PrisberegningA beregning2 = new PrisberegningA(kalk, vare2);
		
		new Thread(beregning1).start(); //Forventet: 900
		new Thread(beregning2).start(); //Forventet: 600
	}
}

class PrisberegningA implements Runnable {
	
	private PriskalkulatorStateful pk;
	private Vare vare;

	public PrisberegningA(PriskalkulatorStateful pk, Vare vare) {
		this.pk = pk;
		this.vare = vare;
	}

	@Override
	public void run() {
		//Tråden må sette tilstand på kalkulatoren for å
		//få utført berengingen.
		pk.setStykkpris(vare.stykkpris());
		pk.setAntall(vare.antall());
		pk.setRabattprosent(vare.prosent());
		System.out.println(pk.beregnTotalPrisMedRabatt());
	}
}

