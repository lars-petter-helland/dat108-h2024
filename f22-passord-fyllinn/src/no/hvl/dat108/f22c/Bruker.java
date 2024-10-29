package no.hvl.dat108.f22c;

import no.hvl.dat108.f22util.PassordService;

public class Bruker {
	
	private String brukernavn;
	private String salt;
	private String passordhash;
	
	public Bruker(String brukernavn, String passord) {
		this.brukernavn = brukernavn;
		this.salt = PassordService.genererTilfeldigSalt();
		this.passordhash = PassordService.hashMedSalt(passord, salt);
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public String getSalt() {
		return salt;
	}

	public String getPassordhash() {
		return passordhash;
	}

	@Override
	public String toString() {
		return "Bruker [\n\tbrukernavn=" + brukernavn + ", \n\tsalt=" + salt 
				+ ", \n\tpassordhash=" + passordhash + "]";
	}

	

}
