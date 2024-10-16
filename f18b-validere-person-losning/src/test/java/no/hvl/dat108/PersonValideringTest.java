package no.hvl.dat108;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class PersonValideringTest {
	
	private Validator validator;
	
	private Person testPerson;
	
	@BeforeEach
	void setUp() {
	    validator = Validation.buildDefaultValidatorFactory().getValidator();
	    
	    testPerson = new Person();
	    testPerson.setNavn("Arne");
	    testPerson.setMobil("12345678");
	    testPerson.setHoydecm(180);
	    testPerson.setFdato(LocalDate.of(1990, 5, 30));
	}
	
	@Test
	void testPersonHarGyldigeInitVerdier() {
		Set<ConstraintViolation<Person>> violations = validator.validate(testPerson);
		assertTrue(violations.isEmpty());
	}

	@Test
	void navnErObligatorisk() {
	    testPerson.setNavn(null);
	    sjekkAtPersonErUgyldigMedDenneEneFeilen("Navn er obligatorisk");
	}

	@Test
	void navnKortereEnn2TegnErUgyldig() {
	    testPerson.setNavn("X");
	    sjekkAtPersonErUgyldigMedDenneEneFeilen("Navn må inneholde minst 2 tegn");
	}

	@Test
	void hoydeOver220cmErUgyldig() {
	    testPerson.setHoydecm(221);
	    sjekkAtPersonErUgyldigMedDenneEneFeilen("Høyde i cm må være mellom 100 og 220");
	}
	
	//Hjelpemetode for å sjekke akkurat en feil
	private void sjekkAtPersonErUgyldigMedDenneEneFeilen(String feilmelding) {
		
		Set<ConstraintViolation<Person>> violations = validator.validate(testPerson);
		assertFalse(violations.isEmpty());
		assertThat(violations).hasSize(1);
		
//		Henter ut feilmeldingen fra det ene violation-objektet
		String violationMessage = violations.iterator().next().getMessage();
		assertEquals(feilmelding, violationMessage);
		
//		Alternativt:
//		assertThat(violations)
//				.extracting(ConstraintViolation::getMessage)
//				.contains(feilmelding);
	}


}
