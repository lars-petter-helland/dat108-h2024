package no.hvl.dat108.asortering;

import java.util.List;

public class Utvalgssortering {
	
	/*
	 * For å fremdeles ha muligheten til å sortere på a.compareTo(b) uten å gi
	 * inn en ekstra paramterer, så beholder vi skallet av den "gamle" metoden,
	 * og gjør her et kall til den nye med a.compareTo(b) som Sammenligner-funksjon.
	 */
	public static <T extends Comparable<? super T>> void sorter(List<T> liste) {
		
		// Slik:
//		Sammenligner<T> naturlig = new Sammenligner<T>() {
//			@Override
//			public int sammenlign(T a, T b) {
//				return a.compareTo(b);
//			}
//		};
		
		// Eller med lambda-uttrykk, slik:
		Sammenligner<T> naturlig = (a, b) -> a.compareTo(b);

		// Eller med metodereferanse (som dere skal lære om senere), slik: 
//		Sammenligner<T> naturlig = T::compareTo;
		
		sorter(liste, naturlig);
	}
	
	/*
	 * Her har vi utvidet sorter med en ekstra Sammenligner-parameter som brukes
	 * i stedet for a.compareTo(b).
	 * 
	 * Kan da sortere på ulike måter bestemt av logikken i Sammenligner-objektet,
	 * og får en mye mer fleksibel og anvendelig sorteringsmetede.
	 */
	public static <T> void sorter(List<T> liste, Sammenligner<T> sammenligner) {
		
		int n = liste.size(); // antall elementer i listen
		
		for (int i = 0; i < n; i++) {
			T min = liste.get(i);
			int minIndeks = i;

			for (int j = i + 1; j < n; j++) {
				T aktuell = liste.get(j);
				
/* Før:			if (aktuell.compareTo(min) < 0) {			*/
/* Nå: */		if (sammenligner.sammenlign(aktuell, min) < 0) {
					min = aktuell;
					minIndeks = j;
				}
			}

			// swap ↄ: bytt liste[i] med min (funnet over)
			T temp = liste.get(i);
			liste.set(i, min);
			liste.set(minIndeks, temp);
		}
	}
}
