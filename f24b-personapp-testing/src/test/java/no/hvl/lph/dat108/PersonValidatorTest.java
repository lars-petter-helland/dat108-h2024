package no.hvl.lph.dat108;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PersonValidatorTest {

	private PersonValidator pv = new PersonValidator();
	
	@Test
	public void gyldigNavnOgFAar() {
		
		Person person = new Person("Per", 1970);
		
		assertTrue(pv.erGyldigNavn(person));
		assertTrue(pv.erGyldigFodselsaar(person));
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "A", "Hans Hansen", "Lars-P"})
	public void ugyldigeNavn(String navnFraListe) {
		
		// Denne testen blir kjørt (i en løkke) for alle navn 
		// listet opp i ValueSource.
		Person person = new Person(navnFraListe, 1970);
		assertFalse(pv.erGyldigNavn(person));
	}

	@ParameterizedTest
	@ValueSource(strings = {"Xi", "HansHansen", "LarsP"})
	public void gyldigeNavn(String navnFraListe) {
		
		// Denne testen blir kjørt (i en løkke) for alle navn 
		// listet opp i ValueSource.
		Person person = new Person(navnFraListe, 1970);
		assertTrue(pv.erGyldigNavn(person));
	}
}
