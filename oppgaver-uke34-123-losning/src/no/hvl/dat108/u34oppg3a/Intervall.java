package no.hvl.dat108.u34oppg3a;

public interface Intervall {
	int getMin();
	int getMax();
	boolean inneholder(int tall);
	boolean overlapper(Intervall other);
}
