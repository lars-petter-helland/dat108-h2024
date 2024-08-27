package no.hvl.dat108.oppg5formatert;

public class Main {
	
	/**
	 * Metoden endrer på strengen som kommer inn v.hj.a. Stringfunksjon format, 
	 * og skriver deretter resultatet ut på skjermen (med System.out.print).
	 *  
		interface Stringfunksjon {
			String anvend(String inn);
		}
     *
	 */
	private static void skrivUtFormatert(String inn, Stringfunksjon format) {
		//Her mangler litt kode - Oppgave 1a)
		String formatertString = format.anvend(inn);
		System.out.println(formatertString);
	}
	/*		a)	Skriv koden som mangler i kodelistingen over. */


	public static void main(String[] args) {
		
/*		b)	Skriv en main-metode som bruker skrivUtFormatert() 
			til å skrive ut en tekst (som du velger selv) med

			i.	Kun store bokstaver, eks. (Java) ->		JAVA 
			ii.	Innrammet, eks. (Java) ->				[Java]
			iii.	Med blank mellom hvert tegn ->		J a v a
			
		Bruk lambda-uttrykk til å representere Stringfunksjon-objektene, 
		og tilordne dem helst til variabler med gode navn før de brukes. */
		
		Stringfunksjon kunStoreBokstaver = s -> s.toUpperCase();
		
		Stringfunksjon innrammet = s -> "[" + s + "]";
		
		//Dette er måten, men kanskje ikke å forvente at man kommer på det på eksamen.
		Stringfunksjon blankeMellom = s -> String.join(" ", s.split("")); 
		
// evt. ... men kanskje ikke å forvente ... Får også dessverre en blank først
//		Stringfunksjon blankeMellom = s -> s.replaceAll("", " "); 
		
// evt. ... denne kan jo forventes ... Gir dessverre en blank sist, men greit !
//		Stringfunksjon blankeMellom = s -> { 
//			String ny = "";
//			for (char tegn : s.toCharArray()) {
//				ny += tegn + " ";
//			} 
//			return ny;
//		};
		
		skrivUtFormatert("Java", kunStoreBokstaver);
		skrivUtFormatert("Java", innrammet);
		skrivUtFormatert("Java", blankeMellom);
	}
}
