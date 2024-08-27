package no.hvl.dat108.f04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Eksempel6
 * 
 * En del eksempler på kilder (source operations) til streams.
 */
public class Eksempel6 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		/*
		 * Dette eksemplet viser en del ulike måter å
		 * opprette en stream på.
		 */

		Stream<Integer> s1 = Stream.of(2,4,5,7,8,9);
		Stream<String> s2 = Stream.of("A", "B");
		
		Integer[] tall = {3,4,5}; 
				//NB! Kan ikke bruke primitiv type int[] her
		
		Stream<Integer> s3 = Stream.of(tall); 
		Stream<Integer> s4 = Arrays.stream(tall);

		String[] navn = {"Anne", "Per", "Knut"};
		Stream<String> s5 = Arrays.stream(navn);
		
		//NB! IntStream er en stream av den primitive typen int
		IntStream s6 = "Hallo".chars(); 
				//NB! Bokstaver (char) er egentlig tall
		IntStream s7 = IntStream.range(1,10);
		IntStream s8 = IntStream.rangeClosed(1, 10);
		
		Stream<Integer> s9 = Stream.iterate(1, x -> x + 1);
		
		try (Stream<String> s10 = Files.lines(Paths.get("data.txt"))) {
		}
	}
}




