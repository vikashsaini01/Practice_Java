package patterns.decorator;

public class Cream extends Condiments{

	protected Cream(Beverage beverage) {
		super(beverage);
	}

	@Override
	public double cost() {
		return 0.2 + this.beverage.cost();
	}

	@Override
	public String display() {
		return "Cream " + this.beverage.display();
	}
	
}
