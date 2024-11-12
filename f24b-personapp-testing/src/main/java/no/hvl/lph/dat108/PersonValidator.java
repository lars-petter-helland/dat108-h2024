package no.hvl.lph.dat108;

import org.springframework.stereotype.Service;

@Service
public class PersonValidator {
	
	public boolean erGyldigNavn(Person p) {
		String regexp = "^[A-Za-zÆØÅæøå]{2,10}$";
		return p.getNavn().matches(regexp);
	}
	
	public boolean erGyldigFodselsaar(Person p) {
		int aar = p.getFodselsaar();
		return aar >= 1900 && aar <= 2024;
	}
	
	public boolean erGyldig(Person p) {
		return erGyldigNavn(p) && erGyldigFodselsaar(p);
	}

}
