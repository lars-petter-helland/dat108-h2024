package no.hvl.dat108.f02tallplukker;

import java.util.ArrayList;
import java.util.List;

public class Tallplukker {

	public static List<Integer> plukkUt(
			List<Integer> liste, Betingelse b) {
		
		List<Integer> svar = new ArrayList<>();
		for(int tall : liste) {
			if(b.erOppfyltFor(tall)) { //Denne linjen
				svar.add(tall);
			}
		}
		return svar;
	}
}
