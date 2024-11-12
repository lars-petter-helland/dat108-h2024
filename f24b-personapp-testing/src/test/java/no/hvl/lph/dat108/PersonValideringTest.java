package no.hvl.lph.dat108;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class PersonValideringTest {

	private Validator validator = Validation
			.buildDefaultValidatorFactory().getValidator();
	
	@Test
	public void gyldigNavnOgFAar() {
		
		Person person = new Person("Per", 1970);
		
		assertTrue(erGyldigEgenskap(person, "navn"));
		assertTrue(erGyldigEgenskap(person, "fodelsaar"));
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "A", "Hans Hansen", "Lars-P"})
	public void ugyldigeNavn(String navnFraListe) {
		
		// Denne testen blir kjørt (i en løkke) for alle navn 
		// listet opp i ValueSource.
		Person person = new Person(navnFraListe, 1970);
		assertFalse(erGyldigEgenskap(person, "navn"));
	}

	@ParameterizedTest
	@ValueSource(strings = {"Xi", "HansHansen", "LarsP"})
	public void gyldigeNavn(String navnFraListe) {
		
		// Denne testen blir kjørt (i en løkke) for alle navn 
		// listet opp i ValueSource.
		Person person = new Person(navnFraListe, 1970);
		assertTrue(erGyldigEgenskap(person, "navn"));
	}

	/***********************************************************************/
	
	/* 
	 * Hjelpemetode til bruk i testingen.
	 * Sjekker feltet med navn feltnavn er gyldig for person.
	 */
	private boolean erGyldigEgenskap(Person person, String egenskap) {
		
		Function<ConstraintViolation<Person>,String> 
				propsWithViolations = v -> v.getPropertyPath().toString();
				
		return !validator.validate(person).stream()		//Strøm av alle feil (ConstraintViolations)
				.map(propsWithViolations)				//Strøm av alle "egenskaper" med feil
				.toList()								//Samlet opp i en liste av "egenskaper" med feil
				.contains(egenskap);					//Om den "egenskapen" vi lurer på har feil
	}

}



