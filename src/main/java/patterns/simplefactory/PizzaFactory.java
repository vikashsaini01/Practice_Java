package patterns.simplefactory;

public class PizzaFactory {

	private static final String PANEER_PIZZA = "PaneerPizza";

	private static final String CHICKEN_PIZZA = "ChickenPizza";

	private static final String INDIAN_SPICY_PIZZA = "IndianSpicyPizza";

	public Pizza createPizza(String pizzaName) {
		if (PANEER_PIZZA.equals(pizzaName)) {
			return new PannerPizza();
		} else if (CHICKEN_PIZZA.equals(pizzaName)) {
			return new ChickenPizza();
		} else if (INDIAN_SPICY_PIZZA.equals(pizzaName)) {
			return new IndianSpicyPizza();
		}
		return null;
	}
}
