package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {

	public static void main(String[] str){
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<Integer> sum1 = es.submit(new Sum(10));
		Future<Integer> sum2 =es.submit(new SumDouble(11));
		Future<Integer> sum3 =es.submit(new SumDouble(10));
		try {
			System.out.println("Sum "+ sum1.get()+ " : " + sum2.get() + " : "+ sum3.get());
			es.shutdown();
		} catch (InterruptedException | ExecutionException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}

}
class Sum implements Callable<Integer>{
	int x;
	public Sum(int x){
		
		this.x = x;
	}
	@Override
	public Integer call(){
		System.out.println("Started 1");
		int sum = 0;
		for(int i = x; i!=0 ; i--){
			sum += i;
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		return sum;
	}
}

class SumDouble implements Callable<Integer>{
	int x;
	public SumDouble(int x){
		
		this.x = x;
	}
	@Override
	public Integer call(){
		System.out.println("Started 2");
		int sum = 0;
		for(int i = x; i!=0 ; i--){
			sum += i;
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		return sum*sum;
	}
}