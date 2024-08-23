package no.hvl.dat108.u34oppg3c;

public class KlokkeslettIntervallTest {
	
	Klokkeslett klokkenHalvTre = new Klokkeslett(14, 30); 
	Klokkeslett klokkenFire = new Klokkeslett(16, 0);
	
	Intervall<Klokkeslett> halvTreTilFire 
			= new LukketIntervall<Klokkeslett>(klokkenHalvTre, klokkenFire);
	
	// ... kom ikke lenger
}
