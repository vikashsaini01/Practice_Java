package patterns.simplefactory;

public class MainClass {
	public static void main(String[] args) {
		PizzaFactory pizzaFactory = new PizzaFactory();
		PizzaStore pizzaStore = new PizzaStore(pizzaFactory);
		pizzaStore.orderPizza("PaneerPizza");
		pizzaStore.orderPizza("IndianSpicyPizza");
	}
}
