package no.hvl.dat108;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "ansatt_avdeling")
public class Ansatt {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id ;

	private String navn;
	private String kjonn;
	private int manedslonn;

	@ManyToOne
    @JoinColumn(name = "avdeling_id")
	private Avdeling avdeling;
	
	@Override
	public String toString() {
		return "Ansatt [id=" + id + ", navn=" + navn + ", kjonn=" + kjonn + ", manedslonn=" + manedslonn + ", avdeling="
				+ avdeling + "]";
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public int getManedslonn() {
		return manedslonn;
	}

	public void setManedslonn(int manedslonn) {
		this.manedslonn = manedslonn;
	}

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}
	
	
	
}
