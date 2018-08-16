package z;

import java.util.Arrays;

public class Ducks implements Comparable<Ducks> {
	int weight;

	public Ducks(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Ducks [weight=" + weight + "]";
	}

	public static void main(String[] args) {
		Ducks[] dks = new Ducks[4];
		dks[0] = new Ducks(3);
		dks[1] = new Ducks(1);
		dks[2] = new Ducks(7);
		dks[3] = new Ducks(2);
		Arrays.sort(dks);
		System.out.println(Arrays.toString(dks));
	}

	@Override
	public int compareTo(Ducks arg0) {
		if (this.weight == arg0.weight)
			return 0;
		else if (this.weight > arg0.weight) {
			return 1;
		} else
			return -1;
	}
}
