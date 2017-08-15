package threads;

import java.util.concurrent.Semaphore;

/*class Que{
	int x;
	Semaphore semaphoreProd = new Semaphore(1);
	Semaphore semaphoreCon = new Semaphore(0);
	public void setX(int x) throws InterruptedException{
		semaphoreProd.acquire();
		this.x=x;
		System.out.println("Set : " + this.x);
		semaphoreCon.release();
	}
	public int getX() throws InterruptedException{
		semaphoreCon.acquire();
		System.out.println("Get : " + this.x);
		semaphoreProd.release();
		return this.x;
	} 
}
class prod implements Runnable{
	Que que;	
	public prod(Que que){
		this.que = que;
		new Thread(this).start();
	}
	public void run(){
		int i = 0 ;
		while(i<30){
			
			try {
				que.setX(i++);
			} catch (InterruptedException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
	}	
}

class Con implements Runnable{
	Que que;
	public Con(Que que){
		this.que = que;
		new Thread(this).start();
	}
	public void run(){
		
		while(true){
			try {
				que.getX();
			} catch (InterruptedException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
	}	
}
*/public class ProdConUsingSemaphore {
	public static void main(String[] arf)
	{
/*		Que que = new Que();
		new prod(que);
		new Con(que);
*/	}
}
