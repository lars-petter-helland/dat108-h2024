package ex1_stateless;

public class MainStateless {

	public static void main(String[] args) {

		/*
		 * Begge trådene bruker samme kalkulator-objekt.
		 * Nå er kalkulatoren stateless, og det er derfor ikke noe
		 * problem at denne deles mellom trådene.
		 */
		PriskalkulatorStateless kalk = new PriskalkulatorStateless();
		
		/*
		 * Trenger noen eksempeldata for å demonstrere problemstillingen.
		 * I "virkeligheten" hadde kanskje disse dataene oppstått i selve 
		 * trådene, men putter de inn i konstrukøren til Prisberegning-
		 * trådene for en enkel demo.
		 */
		Vare vare1 = new Vare(200, 5, 10);
		PrisberegningB beregning1 = new PrisberegningB(kalk, vare1);
		
		Vare vare2 = new Vare(300, 4, 50);
		PrisberegningB beregning2 = new PrisberegningB(kalk, vare2);
		
		new Thread(beregning1).start(); //Forventet: 900
		new Thread(beregning2).start(); //Forventet: 600
	}

}

class PrisberegningB implements Runnable {
	
	private PriskalkulatorStateless pk;
	private Vare vare;

	public PrisberegningB(PriskalkulatorStateless pk, Vare vare) {
		this.pk = pk;
		this.vare = vare;
	}

	@Override
	public void run() {
		//Beregningen er et rent funksjonskall.
		System.out.println(pk.beregnTotalPrisMedRabatt(
				vare.stykkpris(), vare.antall(), vare.prosent()));
	}
}

