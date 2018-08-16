package patterns.command;

public class Fan {
	
	private void highSpeed() {
		System.out.println("Fan running on high speed");
	}
	
	public void on() {
		System.out.println("Fan turned on");
		highSpeed();
	}
	
	public void fanOff() {
		System.out.println("Fan turned off");
	}
}
