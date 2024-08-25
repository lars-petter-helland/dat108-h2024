package no.hvl.dat108.f01recap;

//--------------------------------------------------------------------

interface Skapning {
	void siHei();
}

//--------------------------------------------------------------------
class Hund implements Skapning {
	@Override
	public void siHei() {
		System.out.println("Boff!");
	}
}

//--------------------------------------------------------------------
class Fugl implements Skapning {
	@Override
	public void siHei() {
		System.out.println("Tweet!");
	}
}

//--------------------------------------------------------------------

public class SkapningerMain {
	
	public static void main(String[] args) {
		
		Skapning hund = new Hund();
		Skapning fugl = new Fugl();
		
		//Her definerer vi et objekt av en anonym indre klasse av typen Skapning  
		Skapning katt = new Skapning() {
			@Override
			public void siHei() {
				System.out.println("Mjau!");
			}
		};
		
		//Kan vi definere en skapning ved å bruke et lambda-uttrykk? 
		Skapning bergenser = null;
		
		Skapning[] tabell = {hund, fugl, katt, bergenser};
		
		for (Skapning s : tabell) {
			s.siHei();
		}
	}
}


