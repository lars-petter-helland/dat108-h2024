package no.hvl.dat108.f22a;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

public class HashePassord {

	public static void main(String[] args) 
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		String[] noenPassord = {"Hei", "Hallaien", "pwd123", "Peace&Love"};
		
		for (String passord : noenPassord) {
			
			byte[] passordSomBytes = passord.getBytes("UTF-8");
			System.out.println(passord);
			System.out.println(Arrays.toString(passordSomBytes));
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(passordSomBytes);
			System.out.println(Arrays.toString(hash));
			
			//Hex: 0 (0000) 1 2 ... 9 A B ... F (1111)
			String hex = DatatypeConverter.printHexBinary(hash);
			System.out.println(hex);
			
			//Base64: A (000000) B C ... Z a b c ... z 0 1 .. 9 + / (111111)
			String base64 = Base64.getEncoder().encodeToString(hash);
			System.out.println(base64);
			
		}
	}
	
}
