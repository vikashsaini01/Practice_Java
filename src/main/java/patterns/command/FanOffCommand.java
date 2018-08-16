package patterns.command;

public class FanOffCommand implements Command {

	Fan fan;

	public FanOffCommand(Fan fan) {
		this.fan = fan;
	}

	public void execute() {
		fan.fanOff();
	}

	public void undo() {
		fan.on();
	}

}
