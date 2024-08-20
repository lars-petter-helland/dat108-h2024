package no.hvl.dat108.collsort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		//1. Sortere i "naturlig" rekkefølge i hht. String compareTo. OK
		List<String> listen = Arrays.asList("Hallo", "blabla", "knut", "Per");
		Collections.sort(listen);
		System.out.println(listen);
		
		//2. Sortere alfabetisk uavhengig av store og små bokstaver
		//???
		System.out.println(listen);
		
		//3. ..., nå med lambda-uttrykk !!! :)
		//???
		System.out.println(listen);
		
		//4. Sortere på lengden på strengene (med lambda-uttrykk)
		//???
		System.out.println(listen);
		
		//5. Sortere på lengden synkende. Putte lambda-uttrykk inn i variabel.
		//???
		//???
		System.out.println(listen);
	}
}

