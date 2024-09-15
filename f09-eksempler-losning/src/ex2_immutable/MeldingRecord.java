package ex2_immutable;

public record MeldingRecord(String innhold) {
	
	public MeldingRecord leggTil(String merTekst) {
		return new MeldingRecord(innhold + merTekst);
	}
}
