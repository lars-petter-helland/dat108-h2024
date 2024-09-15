package ex1_stateless;

public class PriskalkulatorStateful {
	
	// Verdien til instansvariablene utgjør kalkulatorens tilstand / state
	private int stykkpris;
	private int antall;
	private double rabattprosent;
	
	public void setStykkpris(int stykkpris) {
		this.stykkpris = stykkpris;
	}
	
	public void setAntall(int antall) {
		this.antall = antall;
	}
	
	public void setRabattprosent(double rabattprosent) {
		this.rabattprosent = rabattprosent;
	}

	public int beregnTotalPrisMedRabatt() {
		return (int) (stykkpris * antall * (1 - rabattprosent/100.0) + 0.5);
	}
	
	
}
