package threads;

class Operation {
	public Operation() {
		System.out.println("Operation Initialized");
	}

	String operand;

	public void operate(String operand1) {
		this.operand = operand1;
		System.out.println("Operation started on : " + operand);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Operation ended on : " + operand);
	}
}

class CallOperation implements Runnable {
	Operation opr;
	String operand;
	Thread t;

	public CallOperation(Operation opr, String operand) {
		this.opr = opr;
		this.operand = operand;
		this.t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		synchronized (opr) {
			opr.operate(operand);
		}
	}
}

public class ThreadRaceCondition {
	public static void main(String[] arg) {
		Operation opr = new Operation();
		CallOperation callOperation = new CallOperation(opr, "Addition");
		CallOperation callOperation2 = new CallOperation(opr, "Subtract");
		CallOperation callOperation3 = new CallOperation(opr, "Multiply");
		CallOperation callOperation4 = new CallOperation(opr, "Divide");

	}
}
