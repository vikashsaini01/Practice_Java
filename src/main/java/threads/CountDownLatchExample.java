package threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample implements Runnable{
	CountDownLatch countDownLatch;
	
	public CountDownLatchExample(CountDownLatch countDownLatch){
		this.countDownLatch = countDownLatch;
	}
	public void run(){
		System.out.println("Starting with Run");
		for(int i = 0; i< 10; i++){
			System.out.println("Value of I : "+ i);
			this.countDownLatch.countDown();
		}
	}
	/**
	 * @param arg
	 */
	public static void main(String[] arg){
		CountDownLatch countDownLatch = new CountDownLatch(6);
		CountDownLatchExample countDownLatchExample = new CountDownLatchExample(countDownLatch);
		Thread t = new Thread(countDownLatchExample);
		t.start();
		try { 
			countDownLatch.await(); 
		} catch (InterruptedException ex) { 
			ex.printStackTrace();
		}
		System.out.println("All events completed");
	}
}
