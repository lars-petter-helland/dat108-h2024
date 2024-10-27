package no.hvl.dat108.webshop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import no.hvl.dat108.webshop.util.InputValidator;

public class ValidatorTest {

    /*
     * Et gyldig brukernavn består av 4 eller flere tegn. Lovlige tegn
     * er bokstaver (små og store) inkl. de norske bokstavene, og tall.
     * Brukernavnet kan ikke begynne med et tall.
     */
	
    @Test
    public void validUsernamesShouldBeOk() {
        assertTrue(InputValidator.isValidUsername("aaaa"));
        assertTrue(InputValidator.isValidUsername("aAaA"));
        assertTrue(InputValidator.isValidUsername("abc4"));
        assertTrue(InputValidator.isValidUsername("A6789b"));
        assertTrue(InputValidator.isValidUsername("A6789b"));
    }
    
    @Test
    public void norwegianLettersShouldBeAllowed() {
        assertTrue(InputValidator.isValidUsername("æøåÆØÅ"));
    }
    
    @Test
    public void shortUsernamesShouldNotBeOk() {
        assertFalse(InputValidator.isValidUsername(null));
        assertFalse(InputValidator.isValidUsername(""));
        assertFalse(InputValidator.isValidUsername("a"));
        assertFalse(InputValidator.isValidUsername("ABC"));
    }
    
    @Test
    public void usernamesWithIllegalCharsShouldNotBeOk() {
        assertFalse(InputValidator.isValidUsername("a-bcd"));
        assertFalse(InputValidator.isValidUsername("a@bcd"));
    }
    
    @Test
    public void usernamesStartingWithANumberShouldNotBeOk() {
        assertFalse(InputValidator.isValidUsername("1abcde"));
        assertFalse(InputValidator.isValidUsername("0ABCDE"));
    }
    
    

}
