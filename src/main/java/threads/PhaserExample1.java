package threads;

import java.util.concurrent.Phaser;

public class PhaserExample1 {
	public static void main(String[]  arg){
		Phaser phaser = new Phaser();
		NewThread newThread = new NewThread(phaser, "A", 100);
		NewThread newThreadB = new NewThread(phaser, "B", 200);
		NewThread newThreadC = new NewThread(phaser, "C", 500);
		NewThread newThreadD = new NewThread(phaser, "D", 500);
		
		
	}
}

class NewThread implements Runnable {
	Phaser phaser;
	int SleepTime;
	Thread thread;

	public NewThread(Phaser phaser, String threadName, int sleepTime) {
		
			
		this.phaser = phaser;
		this.SleepTime = sleepTime;
		System.out.println("Register " + threadName + " " + this.phaser.register());
		System.out.println("Current phase : "+threadName+" " + this.phaser.getPhase());
		thread = new Thread(this, threadName);
		if(threadName.equals("B"))
			thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hi "+this.thread.getName()+" "+i );
			try {
				Thread.sleep(SleepTime);
			} catch (InterruptedException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			System.out.println("Phase : "+thread.getName()+" "  + this.phaser.arriveAndAwaitAdvance());
			
			
		}
		System.out.println("Deregister : Phase : "+thread.getName()+" "  + phaser.arriveAndDeregister()) ; 
	}
}
