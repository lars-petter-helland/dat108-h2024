package no.hvl.dat108;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {
	
	@Size(min=2, message="Navn må inneholde minst 2 tegn")
	@NotNull(message = "Navn er obligatorisk")
	private String navn;
	
	@Pattern(regexp = "^\\d{8}$", message="Mobilnummer må være eksakt 8 sifre")
	@NotNull(message = "Mobil er obligatorisk")
	private String mobil;
	
	@Min(value = 100, message = "Høyde i cm må være mellom 100 og 220")
	@Max(value = 220, message = "Høyde i cm må være mellom 100 og 220")
	private Integer hoydecm;
	
	@Past(message = "Fødselsdato kan ikke være i fremtiden")
	@NotNull(message = "Fødselsdato er obligatorisk")
	private LocalDate fdato;
	
	@Override
	public String toString() {
		return "Person [navn=" + navn + ", mobil=" + mobil 
				+ ", hoydecm=" + hoydecm + ", fdato=" + fdato + "]";
	}
	
	public String getNavn() {
		return navn;
	}
	public String getMobil() {
		return mobil;
	}
	public Integer getHoydecm() {
		return hoydecm;
	}
	public LocalDate getFdato() {
		return fdato;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public void setHoydecm(Integer hoydecm) {
		this.hoydecm = hoydecm;
	}

	public void setFdato(LocalDate fdato) {
		this.fdato = fdato;
	}
	
	
}
