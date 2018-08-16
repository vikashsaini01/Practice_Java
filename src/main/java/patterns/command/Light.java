package patterns.command;

public class Light {
	String lightPlace;
	public Light(String string) {
		lightPlace = string;
	}

	void on() {
		System.out.println(lightPlace+" Lights turned on");
	}
	
	void off() {
		System.out.println(lightPlace+ " Lights turned off");
	}
}
