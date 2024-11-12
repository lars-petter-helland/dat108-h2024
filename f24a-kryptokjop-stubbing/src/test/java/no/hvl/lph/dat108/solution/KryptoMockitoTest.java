package no.hvl.lph.dat108.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.hvl.lph.dat108.Fiat;
import no.hvl.lph.dat108.Krypto;

@ExtendWith(MockitoExtension.class) 
public class KryptoMockitoTest {
	
	private Kryptokalkulator kk;
	
	@Mock
	private Prisfinner prisfinnerStub;
	
	@BeforeEach
	public void nullstill() {
		kk = new Kryptokalkulator();
		kk.setPrisfinner(prisfinnerStub);
	}
	
	@Test
	public void sjekkAtUtregningVirker() throws IOException {
		
		when(prisfinnerStub.finnPris("ETH", "USD"))
				.thenReturn(1234567.89);
		
		double belop = kk.kjope(0.1, Krypto.ETH, Fiat.USD);
		
//		assertEquals(123456.789, belop);
		
		/* Fordi vi jobber med desimaltall kan/vil det alltid bli
		 * avrundingsfeil. Kanskje det holder å sjekke at det er 
		 * korrekt med en feilmargin på 0.0001.
		 */
		assertEquals(123456.789, belop, 0.0001d);
	}
	
	@Test
	public void sjekkAtDetBlirMinusEnVedUnntak() throws IOException {
		
		when(prisfinnerStub.finnPris("ETH", "USD"))
				.thenThrow(IOException.class);
		
		double belop = kk.kjope(0.1, Krypto.ETH, Fiat.USD);
		
		assertEquals(-1.0, belop);
	}
	
}