package patterns.command;

/**
 * Does nothing for execute and undo Placeholder for the NoAction assigned cases
 * 
 * @author vsai12
 *
 */
public final class NoCommand implements Command {
	private static final NoCommand noCommandInstance = new NoCommand();

	public static final NoCommand getNoCommand() {
		return noCommandInstance;
	}

	private NoCommand() {

	}

	public final void execute() {
		System.out.println("No Command");
	}

	public final void undo() {
		System.out.println("No Command");
	}
}
