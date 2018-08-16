package patterns.command;

public class MainClass {
	public static void main(String[] args) {
		Remote remote = new Remote();
		Light light = new Light("Drawing room lights");
		remote.setCommand(0, new LightsOnCommand(light), new LightsOffCommand(light));
		
		remote.pushOffButton(0);
		remote.pushOnButton(0);
		remote.pushOffButton(0);
		remote.undo();
		remote.pushOnButton(1);
		remote.pushOnButton(2);
		remote.undo();
	}
}
