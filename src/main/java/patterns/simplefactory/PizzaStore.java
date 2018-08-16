package patterns.simplefactory;

public class PizzaStore {

	PizzaFactory pizzaFactory;

	public PizzaStore(PizzaFactory pizzaFactory) {
		this.pizzaFactory = pizzaFactory;
	}

	public void orderPizza(String pizzaName) {

		Pizza pizza = pizzaFactory.createPizza(pizzaName);

		bake();
		addFinalToppings();
		prepare();
		cut();
		box();
		print(pizza);
	}

	void bake() {
	}

	void addFinalToppings() {
	}

	void prepare() {
	}

	void cut() {
	}

	void box() {
	}

	void print(Pizza pizza) {
		System.out.println(pizza.details());
	}

}
