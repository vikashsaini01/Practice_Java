package patterns.decorator;

public class Coco extends Condiments{

	public Coco(Beverage beverage) {
		super(beverage);
	}

	@Override
	public double cost() {
		return 0.1 + this.beverage.cost();
	}

	@Override
	public String display() {
		return "Coco " + this.beverage.display();
	}
	
}
