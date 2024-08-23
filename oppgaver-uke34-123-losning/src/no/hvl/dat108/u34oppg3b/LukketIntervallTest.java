package no.hvl.dat108.u34oppg3b;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LukketIntervallTest {
	
	Intervall<Integer> treTilFem = new LukketIntervall<>(3,5);
	Intervall<Integer> fireTilToBaklengs = new LukketIntervall<>(4,2);
	Intervall<Integer> enTilenLike = new LukketIntervall<>(1,1);
	
	Intervall<Double> piTilToPi = new LukketIntervall<>(3.14, 6.28);
	
	@Test void doublegreier() {
		assertFalse(piTilToPi.inneholder(3.13));
		assertTrue(piTilToPi.inneholder(3.14));
		assertTrue(piTilToPi.inneholder(5.0));
		assertTrue(piTilToPi.inneholder(6.28));
		assertFalse(piTilToPi.inneholder(6.29));
		
		// osv ...
	}
	
	
	@Test void testKonstuktor() {
		assertEquals(3, treTilFem.getMin());
		assertEquals(5, treTilFem.getMax());
		
		assertEquals(2, fireTilToBaklengs.getMin());
		assertEquals(4, fireTilToBaklengs.getMax());
		
		assertEquals(1, enTilenLike.getMin());
		assertEquals(1, enTilenLike.getMax());
	}
	
	@Test void inneholder() {
		assertFalse(treTilFem.inneholder(2));
		assertTrue(treTilFem.inneholder(3));
		assertTrue(treTilFem.inneholder(4));
		assertTrue(treTilFem.inneholder(5));
		assertFalse(treTilFem.inneholder(6));
	}
	
	@Test void overlapper() {
		assertTrue(treTilFem.overlapper(fireTilToBaklengs));
		assertTrue(fireTilToBaklengs.overlapper(treTilFem));
		
		assertFalse(enTilenLike.overlapper(fireTilToBaklengs));
		assertFalse(fireTilToBaklengs.overlapper(enTilenLike));
	}
}
