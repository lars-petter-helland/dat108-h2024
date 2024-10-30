package no.hvl.dat108.f22c;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import no.hvl.dat108.f22util.Filhjelper;
import no.hvl.dat108.f22util.PassordService;

public class Ordlisteangrep {
	
	public static void main(String... blablabla) throws IOException {
		
		/*
		 * Fra https://github.com/danielmiessler/SecLists/tree/master/Passwords/Common-Credentials
		 * Har kopiert en liste med de 10000 mest populære passordene. 
		 */
		List<String> passordliste = Filhjelper.lesInnPassordFraFil("10000passord.txt");
		
		/*
		 * Noen oppdiktede brukere. Alle blir lagret med saltet, stretched og hashed passord.
		 */
		List<Bruker> brukerliste = Arrays.asList(
				new Bruker("atle", "passord"),
				new Bruker("brit", "qwerty"),
				new Bruker("carl", "sdfkjsd lfkj sdf"),
				new Bruker("dina", "123456"),
				new Bruker("erik", "HaLlO"),
				new Bruker("fred", "Hei på deg"),
				new Bruker("geir", "madmax"),
				new Bruker("hans", "vladimir"),
				new Bruker("inge", "Liverpool"),
				new Bruker("jens", "liverpool")
				);
		
		for (Bruker bruker : brukerliste) {
            System.out.print("\n" + bruker.getBrukernavn() + " -> ");
			for (String passord : passordliste) {
				if (PassordService.validerMedSalt(passord, bruker.getSalt(), bruker.getPassordhash())) {
					System.out.print(bruker.getBrukernavn() + " har passord '" + passord + "'");
				}
			}
		}
		System.out.println("\nFerdig");
	}
}
