package patterns.decorator;

public abstract class Condiments implements Beverage{
	protected Beverage beverage;

	protected Condiments(Beverage beverage) {
		super();
		this.beverage = beverage;
	}
	
}
