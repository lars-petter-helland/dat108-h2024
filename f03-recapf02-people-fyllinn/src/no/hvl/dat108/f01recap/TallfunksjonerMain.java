package no.hvl.dat108.f01recap;

import java.util.Arrays;

/*
 * I dette eksemplet ser vi på hvordan vi kan delegere en del av en
 * algoritme til et objekt vi tar inn som parameter.
 * 
 * Algoritmen/metoden oppdaterVerdier() oppdaterer alle elementene i en tabell,
 * men delegerer selve oppdateringsskrittet til en Heltallsfunksjon som den
 * tar inn som parameter.
 * 
 * Vi kan ha ulike klasser som implementerer en slik Heltallsfunksjon, og vi 
 * kan derfor tilpasse oppdateringen slik vi ønsker uten å endre på metoden 
 * oppdaterVerdier(). Den blir generell. Hvis vi f.eks. ønsker at alle tall 
 * skal dobles i oppdateringen lager vi et objekt av typen Heltallsfunksjon 
 * som dobler et tall.
 */

interface Heltallsfunksjon {
	int anvend(int tall);
}

//--------------------------------------------------------------------

class Doble implements Heltallsfunksjon {
	@Override
	public int anvend(int tall) {
		return 2 * tall;
	}
}

//--------------------------------------------------------------------

class PlussEn implements Heltallsfunksjon {
	@Override
	public int anvend(int tall) {
		return tall + 1;
	}
}

//--------------------------------------------------------------------

public class TallfunksjonerMain {
	
	public static void main(String[] args) {
		
		int[] tabell = {1,2,3,4,5};
		
		System.out.println("Original: " + Arrays.toString(tabell));
		
		oppdaterVerdier(tabell, new Doble());
		System.out.println("Doble:    " + Arrays.toString(tabell));
		
		oppdaterVerdier(tabell, new PlussEn());
		System.out.println("Pluss en: " + Arrays.toString(tabell));
		
		//Kan vi definere og bruke en heltallsfunksjon "on the fly" via 
		//et lambda-uttrykk? F.eks. for å gjøre minus 1.
		//oppdaterVerdier(tabell, ???);
		System.out.println("Minus en: " + Arrays.toString(tabell));
		
		//Kan vi legge det inn i en variabel først, og heller bruke 
		//variabelen som parameter? F.eks for å dele på 2.
		//???
		//oppdaterVerdier(tabell, ???);
		System.out.println("Halvere:  " + Arrays.toString(tabell));

	}
	
	// Generell metode for å oppdatere alle verdiene i en tabell.
	private static void oppdaterVerdier(int[] tabell, Heltallsfunksjon fu) {
		for (int i=0; i<tabell.length; i++) {
			tabell[i] = fu.anvend(tabell[i]);
		}
	}
}


