package no.hvl.dat108.f04;

import static no.hvl.dat108.f04.People.people;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
 * Eksempel1 / Oppgave i timen
 * 
 * I dette eksemplet skal en liste av Personer gjøres om til en liste
 * av Stringer. Hvordan omformingen fra Person til String skal gjøres
 * skal oppgis som en parameter til metoden hjelpemetoden tilListeAvString().
 * 
 * Fyll inn der det står ???
 */
public class Eksempel1 {
	
	public static List<String> tilListeAvString(List<Person> liste, ???) {
		
		List<String> resultat = new ArrayList<>();
		
		??? 
				
		return resultat;
	}

	public static void main(String[] args) {
		
		//Vi kan prøve å lage en liste av fornavnene til personene i listen
		List<String> fornavnene = tilListeAvString(people, ???);
		System.out.println(fornavnene);		
	}
}
