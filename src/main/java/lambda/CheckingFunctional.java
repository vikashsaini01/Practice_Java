package lambda;

interface SomeProcess{
	void doSomeProcess();
	
	default void doDefaultProcess() {
		System.out.println("Wow .. ");
	}
	
	default void doAnotherDefaultProcess() {
		System.out.println("Wow another default.. ");
	}
}

public class CheckingFunctional implements SomeProcess{

	public static void main(String[] sr) {
		/*
		 * having default method doesn't break the functional interface definition
		 */
		SomeProcess sp = () -> System.out.println("do some process called.");
		
		sp.doSomeProcess();
		
		sp = new CheckingFunctional();
		
		sp.doSomeProcess();
		sp.doDefaultProcess();
		sp.doAnotherDefaultProcess();
	}

	@Override
	public void doSomeProcess() {
		System.out.println("Implemented doSomeProcess");
		
	}
	
	@Override
	public void doDefaultProcess() {
		System.out.println("Default process overridden");
	}
}
