package patterns.strategy;
/**
 * This duck can't fly, It is malnourished  
 * @author vsai12
 *
 */
public class PakiDuck extends ModelDuck  {

	public PakiDuck() {
		this.flyable= new CannotFly();
	}
	
	@Override
	public String whoAmI() {
		return "We are Paki ...:|";
	}

}