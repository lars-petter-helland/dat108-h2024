package no.hvl.dat108;

import java.time.LocalDate;

public class InputValidator {

	/*
	 * "Et gyldig fødselsår er 4 siffer og er mellom 1900 og året vi er i nå"
	 */
	static boolean erGyldigAarstall(String s) {
		
		//Steg1: Ikke godta null
		if (s == null) {
			return false;
		}
		
		//Steg2: Ikke godta om det ikke kan parses
		int aar;
		try {
			aar = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
	
	    //Steg3: Sjekke om gyldig år
		int iAar = LocalDate.now().getYear();
		return 1900 <= aar && aar <= iAar;
	}
}




