package no.hvl.dat108.u34oppg3a;

public class IntervallImpl implements Intervall {
	
	private final int min;
	private final int max;

	public IntervallImpl(int min, int max) {
		if (min <= max) {
			this.min = min;
			this.max = max;
		} else { //bytter de hvis inn i feil rekkefølge
			this.min = max;
			this.max = min;
		}
	}

	@Override
	public int getMin() {
		return min;
	}

	@Override
	public int getMax() {
		return max;
	}

	@Override
	public boolean inneholder(int tall) {
		return min <= tall && tall <= max;
	}

	@Override
	public boolean overlapper(Intervall other) {
		return other.getMax() >= this.min && other.getMin() <= this.max;
	}

}
