package patterns.strategy;

public interface Duck {
	public void setFlyingBheavior(Flyable flyable);
	public void setQuackingBehavior(Quackable quackable);
	
	public void doMoves();	
	public String whoAmI();
}
