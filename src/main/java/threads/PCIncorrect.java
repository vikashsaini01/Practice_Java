package threads;

/**
 * Producer Consumer incorrect
 * 
 * @author hp1
 *
 */

class Qu {
	int x;

	public synchronized void put(int x) {
		this.x = x;
		System.out.println("Put : " + x);
	}

	public synchronized int get() {
		System.out.println("Get : " + x);
		return x;
	}
}

class Producer implements Runnable {
	Qu Qu;
	Thread t;

	Producer(Qu Qu) {
		this.Qu = Qu;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			this.Qu.put(i++);
			if(i>20)
				System.exit(0);
		}
	}
}

class Consumer implements Runnable {
	Qu Qu;
	Thread t;

	Consumer(Qu Qu) {
		this.Qu = Qu;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			this.Qu.get();
		}
	}
}

public class PCIncorrect {
	public static void main(String[] ar) {
		Qu Qu = new Qu();
		Producer p = new Producer(Qu);
		Consumer c = new Consumer(Qu);
	}

}