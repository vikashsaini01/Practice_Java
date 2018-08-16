package patterns.decorator;

public class Latte implements Beverage{

	@Override
	public double cost() {
		return 2.0;
	}

	@Override
	public String display() {
		return "Latte ";
	}
	
}
