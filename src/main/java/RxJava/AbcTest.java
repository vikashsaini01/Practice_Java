package RxJava;

import java.util.concurrent.CountDownLatch;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class AbcTest {
	public static void main(String... strings) throws InterruptedException {
		CountDownLatch res1 = new CountDownLatch(6);
		System.out.println("Main Thread  ... " + Thread.currentThread().getName());
		Observable<Integer> abInt = Observable.create(sub -> {

			sub.onNext(getSome());
			sub.onNext(getSome() + 1);
			sub.onNext(getSome() + 2);
			sub.onNext(getSome() + 3);
			sub.onNext(getSome() + 4);
			sub.onComplete();
			res1.countDown();
		});

		
		abInt = abInt.subscribeOn(Schedulers.computation());

		abInt.subscribe(res -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Use  ... " + res + " .... " + Thread.currentThread().getName());
			res1.countDown();
		});
		res1.await();
	}

	static Integer getSome() {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Emit  ... " + Thread.currentThread().getName());
		return 1 + 2 + 3;
	}
}
