package no.hvl.dat108.u34oppg1;

public class Stjerneformat implements Tallformat {

//En rett frem måte
//	@Override
//	public String somStreng(int tall) {
//		String resultat = "";
//		for (int i=1; i<=tall; i++) {
//			resultat += "★";
//		}
//		return resultat;
//	}

//En litt enklere måte
//Se https://www.baeldung.com/java-string-of-repeated-characters for alternativer
	@Override
	public String somStreng(int tall) {
		return "★".repeat(tall);
	}
}
