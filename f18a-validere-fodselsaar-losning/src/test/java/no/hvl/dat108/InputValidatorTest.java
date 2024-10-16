package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

/*
 * "Et gyldig fødselsår er 4 siffer og er mellom 1900 og året vi er i nå"
 */
public class InputValidatorTest {
	
    int iAar = LocalDate.now().getYear();
	
	@Test
	void nullErUgyldigAar() {
		assertFalse(InputValidator.erGyldigAarstall(null));
	}
	
	@Test
	void tomStringErUgyldigAar() {
		assertFalse(InputValidator.erGyldigAarstall(""));
	}

	@Test
	void ikkeBareSifreErUgyldigAar() {
		assertFalse(InputValidator.erGyldigAarstall("123x"));
		assertFalse(InputValidator.erGyldigAarstall("-200"));
		assertFalse(InputValidator.erGyldigAarstall("-1980"));
		assertFalse(InputValidator.erGyldigAarstall(" 1980"));
		assertFalse(InputValidator.erGyldigAarstall("1980 "));
	}

	@Test
	void ikkeInnenforOmraadeErUgyldigAar() {	
		assertFalse(InputValidator.erGyldigAarstall("123"));
		assertFalse(InputValidator.erGyldigAarstall("12345"));
		assertFalse(InputValidator.erGyldigAarstall("1899"));
		assertFalse(InputValidator.erGyldigAarstall("" + (iAar+1)));
	}

	@Test
	void fireSifreErGyldigAar() {	
		assertTrue(InputValidator.erGyldigAarstall("1900"));
		assertTrue(InputValidator.erGyldigAarstall("1950"));
		assertTrue(InputValidator.erGyldigAarstall("2000"));
		assertTrue(InputValidator.erGyldigAarstall("" + iAar));
	}
}
