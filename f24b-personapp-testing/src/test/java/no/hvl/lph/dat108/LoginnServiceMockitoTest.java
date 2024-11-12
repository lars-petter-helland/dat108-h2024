package no.hvl.lph.dat108;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@ExtendWith(MockitoExtension.class) 
@TestInstance(Lifecycle.PER_CLASS)
public class LoginnServiceMockitoTest {
	
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
	
	@Mock private HttpServletRequest mockRequest;
	@Mock private HttpSession mockSession;

	private LogginnService loginService;

	private Person person;
	
	@BeforeAll
	public void engangsoppsett() {
		
		loginService = new LogginnService();
		
		person = new Person("Per", 2000);
	}
	
    //1 - Sjekke at man ikke er innlogget uten å ha gjort innlogging
	@Test
	public void skalStarteSomIkkeInnlogget() {
		when(mockRequest.getSession(false)).thenReturn(null);
		assertFalse(loginService.erLoggetInn(mockRequest));
	}
	
	@Test
	public void skalStarteSomIkkeInnlogget2() {
		when(mockRequest.getSession(false)).thenReturn(mockSession);
		when(mockSession.getAttribute("user")).thenReturn(null);
		
		assertFalse(loginService.erLoggetInn(mockRequest));
	}
	
	//2 - Sjekke at man er innlogget etter å ha gjort innlogging
	
	//Litt utover pensum å gjøre denne med mockito!
	//Interaction-based testing med verify().
	
//	@Test
//	public void etterInnloggingSkalViVaereInnlogget() {
//		loginService.loggInn(mockRequest, person);
//		assertTrue(loginService.erLoggetInn(mockRequest));
//	}
	
	//3 - Sjekke at man ikke er innlogget etter å ha gjort innlogging, deretter utlogging
	
	//4 - Sjekke at man ikke er innlogget etter kun å ha gjort utlogging
	
	//5 - Sjekke at innlogging timer ut etter en gitt tid
	
	//6 - Sjekke at innlogging gir ny session-id
	
}
