package no.hvl.lph.dat108;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.mock.web.MockHttpServletRequest;

@TestInstance(Lifecycle.PER_CLASS)
public class LoginnServiceSpringMocksTest {
	
	/*
	 * boolean erLoggetInn(HttpServletRequest request)
	 * void loggInn(HttpServletRequest request, Deltager deltager)
	 * void loggUt(HttpServletRequest request)
	 * 
	 */
	
	//1 - I utgangspunktet skal man ikke være innlogget
	//2 - Etter at loggInn er kjørt skal man være innlogget
	//3 - Etter at loggInn er kjørt og deretter loggUt skal man ikke være innlogget
	//...
	// Timeout
	// At innlogging gir ny sessionId
	//...
	
	private LogginnService ls = new LogginnService();

	private MockHttpServletRequest request;		
	
	private Person person;
	
	@BeforeAll
	public void engangsoppsett() {
		person = new Person("Per", 2000);
	}
	
	@BeforeEach
	public void oppsett() {
		request = new MockHttpServletRequest();		
	}
	
    //1 - Sjekke at man ikke er innlogget uten å ha gjort innlogging
	@Test
	public void skalStarteSomIkkeInnlogget() {
		assertFalse(ls.erLoggetInn(request));
	}
	
	//2 - Sjekke at man er innlogget etter å ha gjort innlogging
	@Test
	public void etterInnloggingSkalViVaereInnlogget() {
		ls.loggInn(request, person);
		assertTrue(ls.erLoggetInn(request));
	}
	
	//3 - Sjekke at man ikke er innlogget etter å ha gjort innlogging, deretter utlogging
	
	//4 - Sjekke at man ikke er innlogget etter kun å ha gjort utlogging
	
	//5 - Sjekke at innlogging timer ut etter en gitt tid
	
	//6 - Sjekke at innlogging gir ny session-id
	
}
