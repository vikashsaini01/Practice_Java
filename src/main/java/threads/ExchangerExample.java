package threads;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

	public static void main(String[] str){
		Exchanger<String> exchanger = new Exchanger<>();
		MessageCreator creator = new MessageCreator(exchanger);
		MessageClass messageClass = new MessageClass(exchanger);
		
		new Thread(messageClass).start();
		new Thread(creator).start();
	}
}

class MessageCreator implements Runnable {
	Exchanger<String> exchanger;

	public MessageCreator(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		String x = "Hi ";
		for (int i = 0; i < 5; i++) {
			String str = null;
			try {
				str = this.exchanger.exchange(x + i);
			} catch (InterruptedException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			System.out.println("Received back "+ str);
		}
	}
}

class MessageClass implements Runnable {

	Exchanger<String> exchanger;
	String x;

	public MessageClass(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
		this.x = "Hello ";
	}

	@Override
	public void run() {

		String str = null;
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(2000);
				str = this.exchanger.exchange(x+ i);
				System.out.println(" Received : " + str);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}		
	}
}