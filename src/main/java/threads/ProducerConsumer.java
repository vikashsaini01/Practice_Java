package threads;

import java.util.ArrayList;
import java.util.List;

class Queue {
	List<Integer> xList;

	public Queue() {
		xList = new ArrayList<Integer>();
	}

	public synchronized int get() {
		while (xList.size() == 0) {
			try {
				System.out.println("Queue empty now");
				wait();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		notifyAll();
		int z = xList.get(0);
		System.out.println("Get : " + z);
		xList.remove(0);
		return z;
	}

	public synchronized void set(int x) {
		while (xList.size() >= 15) {
			try {
				System.out.println("Queue full now");
				wait();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		notifyAll();
		System.out.println("Sleep start");
		try {
			Thread.sleep(200);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Sleep end");
		System.out.println("Set : " + x);
		this.xList.add(x);
		
	}
}

class Q {
	int x;
	boolean valueSet = false;

	public synchronized int get() {
		while (!valueSet) {
			try {
				wait();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Get : " + x);
		valueSet = false;
		notifyAll();
		return x;
	}

	public synchronized void set(int x) {
		while (valueSet) {
			try {
				wait();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Set : " + x);
		this.x = x;
		valueSet = true;
		notify();
	}
}

class Producer1 implements Runnable {
	Q q;

	public Producer1(Q q) {
		this.q = q;
		new Thread(this).start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			q.set(i++);
			if (i > 20)
				System.exit(0);
		}
	}
}

class Consumer1 implements Runnable {
	Q q;

	public Consumer1(Q q) {
		this.q = q;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			q.get();
		}
	}
}

public class ProducerConsumer {
	public static void main(String[] arf) {
		/*
		 * Q q = new Q(); Producer1 p1 = new Producer1(q); Consumer1 c1 = new
		 * Consumer1(q);
		 */

		Queue q1 = new Queue();
		Producer_list pw = new Producer_list(q1);
		Consumer_list cw = new Consumer_list(q1);

	}
}

class Producer_list implements Runnable {
	Queue q;

	public Producer_list(Queue q) {
		this.q = q;
		new Thread(this).start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			q.set(i++);
			if (i > 20)
				System.exit(0);
		}
	}
}

class Consumer_list implements Runnable {
	Queue q;

	public Consumer_list(Queue q) {
		this.q = q;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			q.get();
		}
	}
}