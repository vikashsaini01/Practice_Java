package threads;

import java.util.concurrent.Phaser;

public class PhaserExample2 {
	public static void main(String[]  arg){
		Phaser phaser = new Phaser(){
			@Override
			protected boolean onAdvance(int phase, int parties) {
				if(phase == 6)
					return true;
				return parties == 0;
			}
		};
		NewThread2 newThread = new NewThread2(phaser, "A", 100);
		NewThread2 newThreadB = new NewThread2(phaser, "B", 100);
		NewThread2  newThreadC = new NewThread2(phaser, "C", 100);
		NewThread2 newThreadD = new NewThread2(phaser, "D", 100);
		
		
	}
}

class NewThread2 implements Runnable {
	Phaser phaser;
	int SleepTime;
	Thread thread;

	public NewThread2(Phaser phaser, String threadName, int sleepTime) {
		
			
		this.phaser = phaser;
		this.SleepTime = sleepTime;
		System.out.println("Register " + threadName + " " + this.phaser.register());
		System.out.println("Current phase : "+threadName+" " + this.phaser.getPhase());
		thread = new Thread(this, threadName);
		thread.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 8 && !phaser.isTerminated(); i++) {
			
		
			
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
