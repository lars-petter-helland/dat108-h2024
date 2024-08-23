package no.hvl.dat108.u34oppg3b;

public class LukketIntervall<T extends Comparable<T>> implements Intervall<T> {
	
	private T min;
	private T max;

	public LukketIntervall(T min, T max) {
		if (min.compareTo(max) <= 0) {
			this.min = min;
			this.max = max;
		} else {
			this.min = max;
			this.max = min;
		}
	}

	@Override
	public T getMin() {
		return min;
	}

	@Override
	public T getMax() {
		return max;
	}

	@Override
	public boolean inneholder(T tall) {
		return min.compareTo(tall) <= 0 && tall.compareTo(max) <= 0;
	}

	@Override
	public boolean overlapper(Intervall<T> other) {
		return other.getMax().compareTo(this.min) >= 0 
				&& other.getMin().compareTo(this.max) <= 0;
	}

}
