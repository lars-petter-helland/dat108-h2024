package no.hvl.dat108.u34oppg1;

class Romertallformat implements Tallformat {

	@Override
	public String somStreng(int tall) {
		
		// Les om switch f.eks. her:
		// - https://medium.com/@brunozambiazi/enhanced-switch-statements-in-java-17-31f3487763a0
		// - https://nipafx.dev/java-switch/
		//
		// Og for de "avanserte":
		// - https://bayramblog.medium.com/embracing-modern-java-the-evolution-of-switch-in-java-21-199cf999841a
		//
		String romertall = switch(tall) {
			case 1 -> "I";
			case 2 -> "II";
			case 3 -> "III";
			case 4 -> "IV";
			case 5 -> "V";
			default -> "?";
		};
		return romertall;
	}
}
