package no.hvl.dat108.f01recap;

//--------------------------------------------------------------------

interface Flate {
	double areal();
}

//--------------------------------------------------------------------

class Rektangel implements Flate {
	
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

//--------------------------------------------------------------------

class Sirkel implements Flate {
	
	private double radius;
	
	public Sirkel(double radius) {
		this.radius = radius;
	}

	@Override
	public double areal() {
		return Math.PI * radius * radius;
	}
}

//--------------------------------------------------------------------

public class FlaterMain {
	
	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		Flate rektangel = new Rektangel(2, 3);
		System.out.println(rektangel.areal());
		
		Flate sirkel = new Sirkel(4);
		System.out.println(sirkel.areal());
		
		// Kan vi definere en flate som et lambda-uttrykk?
		Flate ukjent = null; 
		System.out.println(ukjent.areal());
	}
}
