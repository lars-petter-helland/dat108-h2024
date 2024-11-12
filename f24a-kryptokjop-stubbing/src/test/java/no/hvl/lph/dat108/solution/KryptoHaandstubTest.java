package no.hvl.lph.dat108.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import no.hvl.lph.dat108.Fiat;
import no.hvl.lph.dat108.Krypto;

public class KryptoHaandstubTest {
	
	@Test
	public void sjekkAtUtregningVirker() {
		
		Kryptokalkulator kk = new Kryptokalkulator();
		kk.setPrisfinner(new PrisfinnerMedHardkodetPris());
		
		double belop = kk.kjope(0.1, Krypto.ETH, Fiat.USD);
		
		/*
		 * Fordi Kryptokalkulatoren bruker vår PrisfinnerTestStub
		 * til å finne pris (som alltid har kurs = 1234567.89) må vi
		 * forvente at beløpet blir 123456.789. Da sjekker vi om
		 * utregningen har virket:
		 */
//		assertEquals(123456.789, belop);
		
		/* Fordi vi jobber med desimaltall kan/vil det alltid bli
		 * avrundingsfeil. Kanskje det holder å sjekke at det er 
		 * korrekt med en feilmargin på 0.0001.
		 */
		assertEquals(123456.789, belop, 0.00000001d);
	}
	
	@Test
	public void sjekkAtDetBlirMinusEnVedUnntak() {
		
		Kryptokalkulator kk = new Kryptokalkulator();
		kk.setPrisfinner(new PrisfinnerSomKasterUnntak());
		
		double belop = kk.kjope(0.1, Krypto.ETH, Fiat.USD);
		assertEquals(-1.0, belop);
	}
	
}