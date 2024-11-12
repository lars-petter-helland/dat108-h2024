package no.hvl.lph.dat108.solution;

import java.io.IOException;

public class PrisfinnerMedHardkodetPris implements Prisfinner {

	/* Returnerer alltid en kryptokurs på 1234567.89 */
	@Override
	public double finnPris(String kryptoCode, String fiatCode) throws IOException {
		return 1234567.89d;
	}
	
	
}