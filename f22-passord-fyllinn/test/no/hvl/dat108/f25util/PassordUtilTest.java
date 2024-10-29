package no.hvl.dat108.f25util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat108.f22util.PassordService;

class PassordUtilTest {
	
	private static final String RIKTIG_PASSORD = "Abc de fgh";
	private static final String FEIL_PASSORD = "Java er kjedelig";
	
	private String salt;
	private String hash;
	
	@BeforeEach
	void setup() {
        salt = PassordService.genererTilfeldigSalt();
        hash = PassordService.hashMedSalt(RIKTIG_PASSORD, salt);
//        System.out.println(hash);
	}

	@Test
	void riktigPassordVirker() {
        assertTrue(PassordService.validerMedSalt(RIKTIG_PASSORD, salt, hash));
	}

	@Test
	void feilPassordVirkerIkke() {
        assertFalse(PassordService.validerMedSalt(FEIL_PASSORD, salt, hash));
	}
	
	@Test
	void tomHashVirkerIkke() {
        assertFalse(PassordService.validerMedSalt(FEIL_PASSORD, salt, ""));
	}
	
	@Test
	void nullPassordKasterUnntak1() {
        assertThrows(IllegalArgumentException.class, 
        		() -> PassordService.hashMedSalt(null, salt));
	}
	
	@Test
	void nullPassordKasterUnntak2() {
        assertThrows(IllegalArgumentException.class, 
        		() -> PassordService.validerMedSalt(null, salt, hash));
	}
	
	@Test
	void nullHashKasterUnntak() {
        assertThrows(IllegalArgumentException.class, 
        		() -> PassordService.validerMedSalt(RIKTIG_PASSORD, salt, null));
	}
	
}
