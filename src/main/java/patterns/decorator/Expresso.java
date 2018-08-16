package patterns.decorator;

public class Expresso implements Beverage{

	@Override
	public double cost() {
		return 3.5;
	}

	@Override
	public String display() {
		return "Expresso ";
	}
	
}
