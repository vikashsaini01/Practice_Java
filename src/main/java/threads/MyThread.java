package threads;

public class MyThread extends Thread{

	String threadName;
	public MyThread(String threadName)
	{
		this.threadName = threadName;
	}
	int x = 2;
	
	public int compute(){
		x = x*x ;
		return x ; 
	}
	public void run() {
		for(int i =0; i <30; i++){
			System.out.println(i + threadName +  compute());
			try {
				Thread.sleep(150);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] arg){
		Thread t1 = new MyThread(" One : "); 
		t1.start();
		
		Thread t2 = new MyThread(" Two : "); 
		t2.start();
		
		for(int i =0; i <30; i++){
			System.out.println("Main Thread : " + t1.isAlive() + "   " + t2.isAlive());
			try {
				Thread.sleep(50);
				if(i==28)
				{
					t1.join();
					t2.join();
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}


