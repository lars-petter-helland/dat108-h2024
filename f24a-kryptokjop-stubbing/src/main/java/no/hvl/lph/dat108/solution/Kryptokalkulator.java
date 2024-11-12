package no.hvl.lph.dat108.solution;

import java.io.IOException;

import org.springframework.stereotype.Service;

import no.hvl.lph.dat108.Fiat;
import no.hvl.lph.dat108.Krypto;

@Service
public class Kryptokalkulator {
	
	/*
	 * Bruk interface (her Prisfinner) som type på objekter man 
	 * samarbeider med. Da får man en løsere og mer fleksibel kobling 
	 * til konkrete klasser (her PrisfinnerKucoin).
	 */
	private Prisfinner prisfinner = new PrisfinnerKucoin();
	
	/*
	 * En mekanisme for Dependency Injection gjør det mulig å sette
	 * inn ulike Prisfinnere etter behov, f.eks. når man skal teste at
	 * kjope()-metoden virker. 
	 */
	public void setPrisfinner(Prisfinner prisfinner) {
		this.prisfinner = prisfinner;
	}

	public double kjope(double antall, Krypto krypto, Fiat fiat) {
		try {
			return antall * prisfinner.finnPris(
					krypto.name(), fiat.name());
			
		} catch (IOException e) {
			return -1;
		}
	}
}
