package no.hvl.dat108.utplukk;

import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		List<Integer> listen = List.of(-4, 9, 2, 7, 6, 0);
		List<Integer> resultat = null;;

		System.out.println("Listen:      " + listen);

		//1. Plukk ut og returner alle partall
		//??? resultat = Tallplukker.plukkUt(listen, ???);
		System.out.println("Partallene:  " + resultat);
		
		//2. Plukk ut og returner alle tall større enn 3
		//??? resultat = Tallplukker.plukkUt(listen, ???);
		System.out.println("Tallene > 3: " + resultat);
	}
}

