package no.hvl.lph.dat108.solution;

import java.io.IOException;

public interface Prisfinner {
	double finnPris(String kryptoCode, String fiatCode) throws IOException;
}
