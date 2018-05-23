package patterns.strategy;

public class CannotFly implements Flyable {
	public String fly() {
		// cant fly. No engine, no wings.
		return "Can't fly :( :( :(";
	}
}
