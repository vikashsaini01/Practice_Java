package RxJava;

import java.util.concurrent.CountDownLatch;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class AbcTest2 {
	public static void main(String... strings) throws InterruptedException {
		CountDownLatch res1 = new CountDownLatch(2);
		
		System.out.println("Main Thread  ... " + Thread.currentThread().getName());
		Observable<Integer> abInt = Observable.just(getInt());
		abInt = abInt.subscribeOn(Schedulers.computation());

		
		abInt.subscribe(res -> {
			System.out.println("Got   ... " + res + " .... " + Thread.currentThread().getName());
			res1.countDown();
		});
		
		
		res1.countDown();
		res1.await();
	}

	static Integer getInt() {
		System.out.println(5+ " ... Emit  ... " +  Thread.currentThread().getName());
		return 5;
	}
	
	
}
