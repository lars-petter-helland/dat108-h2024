package ex2_immutable;

public class MeldingImmutable {
	
	private final String innhold;

	public MeldingImmutable(String innhold) {
		this.innhold = innhold;
	}

	public String getInnhold() {
		return innhold;
	}

	public MeldingImmutable leggTil(String merTekst) {
		return new MeldingImmutable(innhold + merTekst);
	}
	
	@Override
	public String toString() {
		return "MeldingImmutable [innhold=" + innhold + "]";
	}
	
}
