package no.hvl.dat108.asortering;

import java.util.List;

public class Utvalgssortering {
	
	public static <T extends Comparable<? super T>> void sorter(List<T> liste) {
		
		int n = liste.size(); // antall elementer i listen
		
		for (int i = 0; i < n; i++) {
			T min = liste.get(i);
			int minIndeks = i;

			for (int j = i + 1; j < n; j++) {
				T aktuell = liste.get(j);
				
				if (aktuell.compareTo(min) < 0) { // spør om aktuell < min
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
