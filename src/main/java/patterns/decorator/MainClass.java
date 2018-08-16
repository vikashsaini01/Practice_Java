package patterns.decorator;

public class MainClass {
	
	public static void main(String[] args) {
		Beverage beverage = new Expresso();
		System.out.println(beverage.display() + " @ " +beverage.cost() );
		
		beverage = new Cream(beverage);
		System.out.println(beverage.display()+ " @ " +beverage.cost());
		
		beverage = new Coco(beverage);
		System.out.println(beverage.display()+ " @ " +beverage.cost());
		
		beverage = new Mocha(beverage);
		System.out.println(beverage.display()+ " @ " +beverage.cost());
		
		System.out.println();
		
		Beverage beverage1 = new Cappuccino();
		System.out.println(beverage1.display() + " @ " +beverage1.cost() );
		
		beverage1 = new Mocha(beverage1);
		System.out.println(beverage1.display()+ " @ " +beverage1.cost());
		
		beverage1 = new Cream(beverage1);
		System.out.println(beverage1.display()+ " @ " +beverage1.cost());
		
		beverage1 = new Cream(beverage1);
		System.out.println(beverage1.display()+ " @ " +beverage1.cost());
	}
}
