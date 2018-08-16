package patterns.command;

public class Remote {
	private final int remoteSize = 5;
	Command[] commandsOn = new Command[remoteSize];
	Command[] commandsOff = new Command[remoteSize];
	Command lastCommand;

	public Remote() {
		for (int i = 0; i < remoteSize; i++) {
			commandsOn[i] = NoCommand.getNoCommand();
			commandsOff[i] = NoCommand.getNoCommand();
		}
		lastCommand = NoCommand.getNoCommand();
	}

	public void setCommand(int index, Command onCommand, Command offCommand) {
		this.commandsOn[index] = onCommand;
		this.commandsOff[index] = offCommand;
	}
	
	public void pushOnButton(int index) {
		commandsOn[index].execute();
		lastCommand= commandsOn[index];
	}
	
	public void pushOffButton(int index) {
		commandsOff[index].execute();
		lastCommand= commandsOff[index];
	}
	
	public void undo() {
		lastCommand.undo();
	}
}
