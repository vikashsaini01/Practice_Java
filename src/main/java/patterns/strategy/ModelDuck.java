package patterns.strategy;

public abstract class ModelDuck implements Duck{

	protected Flyable flyable;
	protected Quackable quackable;
	
	protected ModelDuck() {
		flyable = new FlyWithWings();
		quackable = new QuackQuack();
	}
	
	@Override
	public void setFlyingBheavior(Flyable flyable) {
		this.flyable= flyable;
	}

	@Override
	public void setQuackingBehavior(Quackable quackable) {
		this.quackable =quackable;
	}

	@Override
	public void doMoves() {
		System.out.println(whoAmI() + " : "+ flyable.fly()+ "  :  " + quackable.quack());
		
	}
	
	@Override
	public String whoAmI() {
		return this.getClass().getSimpleName();
	}

}
