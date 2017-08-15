package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample implements Runnable{
	
	CyclicBarrier cyclicBarrier;
	String name;
	public CyclicBarrierExample(CyclicBarrier cyclicBarrier, String name){
		this.cyclicBarrier  = cyclicBarrier;
		this.name = name;
	}
	
	public void run(){
		System.out.println("Starting run");
		for(int i =0; i<3; i++){			
			System.out.println(name+ " Value of i : " + i);
			try {
				cyclicBarrier.await();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} catch (BrokenBarrierException ex) {
				ex.printStackTrace();
			}			
		}
	}
	public static void main(String[] arg)
	{
		CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new ActNow());
		CyclicBarrierExample barrierExample = new CyclicBarrierExample(cyclicBarrier, "A");
		CyclicBarrierExample barrierExampleb = new CyclicBarrierExample(cyclicBarrier, "B");
		CyclicBarrierExample barrierExamplec = new CyclicBarrierExample(cyclicBarrier, "C");
		Thread t = new Thread(barrierExamplec);
		t.start();
		Thread thread = new Thread(barrierExampleb);
		thread.start();
		
		Thread thread2 = new Thread(barrierExample);
		thread2.start();
	}
}

class ActNow implements Runnable{
	public void run(){
		System.out.println("Hey, Everything is done. Cheers!! ");
	}
}
