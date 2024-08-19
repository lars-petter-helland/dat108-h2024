package no.hvl.dat108.sirkelrektangel;

public class Rektangel implements Flate {
	
	double bredde;
	double hoyde;
	
	public Rektangel(double bredde, double hoyde) {
		this.bredde = bredde;
		this.hoyde = hoyde;
	}

	@Override
	public double areal() {
		return bredde * hoyde;
	}
}
