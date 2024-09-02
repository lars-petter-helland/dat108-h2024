package no.hvl.dat108.f05;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.stream.LongStream;

public class Eks7parallell {

	public static void main(String[] args) {

		long startTime = System.nanoTime();

		String solution = LongStream.iterate(0L, tall -> tall + 1)
				.parallel() // evt. for å utnytte flere kjerner samtidig
				.mapToObj(tall -> sha256HashOf(tall))
				.filter(hash -> hash.startsWith("00000"))
				.findAny().orElse("Not found");

		long elapsedTime = System.nanoTime() - startTime;

		System.out.printf("Funnet etter %s sekunder:%n", elapsedTime / 1_000_000_000.0);
		System.out.println(solution);
		
		// Uten .parallel(): Funnet etter 45.xxx sekunder
		// Med  .parallel(): Funnet etter 18.xxx sekunder
	}

	private static String sha256HashOf(long number) {
		try {
			byte[] numberAsBytes = String.valueOf(number).getBytes("UTF-8");
			byte[] sha256AsBytes = MessageDigest.getInstance("SHA-256").digest(numberAsBytes);
			
			return Base64.getEncoder().encodeToString(sha256AsBytes);

		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
