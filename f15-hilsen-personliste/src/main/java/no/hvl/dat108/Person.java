package no.hvl.dat108;

public class Person { 
	
	private String firstName;
	private String lastName;
	private int alder;
	
	public Person(String firstName, String lastName, int alder) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.alder = alder;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAlder() {
		return alder;
	}
}
