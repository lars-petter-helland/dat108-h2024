package no.hvl.dat108.u34oppg3c;

public class Klokkeslett implements Comparable<Klokkeslett> {
	
	private int time;	// 0..23
	private int minutt;	// 0..59
	
	public Klokkeslett(int time, int minutt) {
		if (time < 0 || time > 23 || minutt < 0 || minutt > 59) {
			throw new IllegalArgumentException();
		}
		this.time = time;
		this.minutt = minutt;
	}

	public int getTime() {
		return time;
	}

	public int getMinutt() {
		return minutt;
	}

	@Override
	public int compareTo(Klokkeslett other) {
		return (this.time*60 + this.minutt) - (other.time*60 + other.minutt);
	}
}
