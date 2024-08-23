package no.hvl.dat108.u34oppg1;

public class Main {
	
	public static void main(String[] args) {
		
		int[] tabell = {2,3,1,5};
		skrivUtTallene(tabell, new Stjerneformat());
		skrivUtTallene(tabell, new Romertallformat());
	}
	
	private static void skrivUtTallene(int[] tabell, Tallformat format) {
		for (int tall : tabell) {
			System.out.println(format.somStreng(tall));
		}
	}
}
