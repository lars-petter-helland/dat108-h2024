package no.hvl.dat108.u34oppg3a;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HeltallIntervallTest {
	
	Intervall treTilFem = new IntervallImpl(3,5);
	Intervall fireTilTo = new IntervallImpl(4,2);
	Intervall syvTilsyv = new IntervallImpl(7,7);
	
	@Test void konstruktor() {
		assertEquals(3, treTilFem.getMin());
		assertEquals(5, treTilFem.getMax());
		
		assertEquals(2, fireTilTo.getMin());
		assertEquals(4, fireTilTo.getMax());
		
		assertEquals(7, syvTilsyv.getMin());
		assertEquals(7, syvTilsyv.getMax());
	}
	
	@Test void inneholder() {
		assertTrue(treTilFem.inneholder(3));
		assertTrue(treTilFem.inneholder(4));
		assertTrue(treTilFem.inneholder(5));
		
		assertFalse(treTilFem.inneholder(2));
		assertFalse(treTilFem.inneholder(6));
	}
	
	@Test void overlapper() {
		assertTrue(treTilFem.overlapper(fireTilTo));
		assertTrue(fireTilTo.overlapper(treTilFem));
		
		assertFalse(syvTilsyv.overlapper(fireTilTo));
		assertFalse(fireTilTo.overlapper(syvTilsyv));
	}
}
