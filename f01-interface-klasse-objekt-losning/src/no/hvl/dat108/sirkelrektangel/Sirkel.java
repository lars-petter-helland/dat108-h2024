package no.hvl.dat108.sirkelrektangel;

public class Sirkel implements Flate {
	
	private double radius;
	
	public Sirkel(double radius) {
		this.radius = radius;
	}

	@Override
	public double areal() {
		return Math.PI * radius * radius;
	}
}
