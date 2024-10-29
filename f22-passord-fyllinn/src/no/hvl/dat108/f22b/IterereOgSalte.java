package no.hvl.dat108.f22b;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

public class IterereOgSalte {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

		final String HASH_FUNCTION = "SHA-256";
		final int SALTLENGDE = 16;
		final int ITERASJONER = 1000;
		final String ENCODING = "Base64";

		String passord = "Hallaien";

		// 1 - Gjøre om fra String til byte[]
		byte[] passordSomBytes = passord.getBytes("UTF-8");

		System.out.println("Passord: " + passord);
		System.out.println("Passord som bytes: " + Arrays.toString(passordSomBytes));

		// 2 - Generer et tilfeldig salt i form av en byte[]
		byte[] salt = new byte[SALTLENGDE];
		new SecureRandom().nextBytes(salt);

		System.out.println("Salt: " + Arrays.toString(salt));

		// 3 - Slå sammen salt og passord til en enkelt tabell 
		byte[] saltPlussPassord = new byte[salt.length + passordSomBytes.length];
		System.arraycopy(salt, 0, saltPlussPassord, 0, salt.length);
		System.arraycopy(passordSomBytes, 0, saltPlussPassord, salt.length, passordSomBytes.length);

		System.out.println("Salt+Passord: " + Arrays.toString(saltPlussPassord));

		// 4 - Utføre hashing et antall ganger for å gjøre algoritmen treigere
		MessageDigest md = MessageDigest.getInstance(HASH_FUNCTION);
		byte[] digest = saltPlussPassord;
		for (int i = 1; i <= ITERASJONER; i++) {
			digest = md.digest(digest);
		}
		
		System.out.println("Hashet med " + HASH_FUNCTION + ": " + Arrays.toString(digest));

		// 5 - Gjøre om fra byte[] til String igjen
		String kodetDigest = "";
		if (ENCODING.equalsIgnoreCase("Hex")) {
			kodetDigest = DatatypeConverter.printHexBinary(digest);
			System.out.println("Hex-kodet digest: " + kodetDigest);

		} else if (ENCODING.equalsIgnoreCase("Base64")) {
			kodetDigest = DatatypeConverter.printBase64Binary(digest);
			System.out.println("Base64-kodet digest: " + kodetDigest);

		} else {
			System.out.println("Invalid encoding: " + ENCODING);
		}
	}

}
