package patterns.command;

public class FanOnCommand implements Command {

	Fan fan;

	public FanOnCommand(Fan fan) {
		this.fan = fan;
	}

	public void execute() {
		fan.on();
	}

	public void undo() {
		fan.fanOff();
	}

}
