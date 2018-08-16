package patterns.decorator;

public class Cappuccino implements Beverage {

	@Override
	public double cost() {
		return 3.0;
	}

	@Override
	public String display() {
		return "Cappuccino ";
	}
	
}
