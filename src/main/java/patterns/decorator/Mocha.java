package patterns.decorator;

public class Mocha extends Condiments {

	protected Mocha(Beverage beverage) {
		super(beverage);
	}

	@Override
	public double cost() {
		return 0.5 + this.beverage.cost();
	}

	@Override
	public String display() {
		return "Mocha " + this.beverage.display();
	}

}
