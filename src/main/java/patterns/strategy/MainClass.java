package patterns.strategy;

public class MainClass {

	public static void main(String... strings) {
		Quackable quackChi = new QuackQuackChiChi();
		
		
		
		Duck indianDuck = new IndianDuck();		
		indianDuck.setQuackingBehavior(quackChi);
		indianDuck.doMoves();
		

		Duck pakiDuck = new PakiDuck();
		pakiDuck.doMoves();
		
		
		
		Duck germanDuck = new GermanDuck();
		germanDuck.setFlyingBheavior(new FlyWithEngine());
		germanDuck.doMoves();
		
		
		Duck aussieDuck = new AussieDuck(new NoFlyingButJumpingHigh());	
		aussieDuck.doMoves();

	}
}
