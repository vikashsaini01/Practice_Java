package threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterExample {
	public static void main(String[] str){
		CountDownLatch latch  = new CountDownLatch(12);
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		ThreadExecuterExample example = new ThreadExecuterExample(latch, "A");
		ThreadExecuterExample exampleB = new ThreadExecuterExample(latch, "B");
		ThreadExecuterExample exampleC = new ThreadExecuterExample(latch, "C");
		ThreadExecuterExample exampleD = new ThreadExecuterExample(latch, "D");
		ThreadExecuterExample exampleE = new ThreadExecuterExample(latch, "E");
		
		service.execute(exampleE);
		service.execute(exampleD);
		service.execute(exampleC);
		service.execute(exampleB);
		service.execute(example);
		
		try{
			latch.await();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		service.shutdown();
		System.out.println("Ending ");
	}
	
}
class ThreadExecuterExample implements Runnable{
	CountDownLatch latch;
	Thread thread;
	String name;
	public ThreadExecuterExample (CountDownLatch latch, String name){
		this.latch = latch;
		//this.thread = new Thread(this);
		this.name = name;
	}
	@Override
	public void run(){
		for(int i =4; i>=0; i--){
			System.out.println(name+ "-value of i : " +  i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			latch.countDown(); 
		}
	}
}