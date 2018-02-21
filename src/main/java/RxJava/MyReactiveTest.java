package RxJava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MyReactiveTest {

	public Observable<String> getObservable() {
		Observable<String> ob = Observable.create(emitter -> {
			emitter.onNext("Vikash");
			emitter.onNext("Tarun");
			emitter.onNext("Abhimanyu");
			emitter.onNext("Jatin");
			if (Math.random() > 0.7)
				emitter.onError(new Exception("Error in emit"));
			emitter.onComplete();
		});

		return ob;
	}

	public static void main(String[] str) {
		MyReactiveTest myReactiveTest = new MyReactiveTest();

		Observable<String> ob = myReactiveTest.getObservable();
		ob.subscribe(new Observer<String>() {

			@Override
			public void onComplete() {
				System.out.println("Emit completed ");

			}

			@Override
			public void onError(Throwable e) {
				System.out.println("Some error occurred " + e.getMessage());

			}

			@Override
			public void onNext(String t) {
				System.out.println("Got item " + t);

			}

			@Override
			public void onSubscribe(Disposable d) {
				System.out.println("Subscribe called now ");

			}
		});

	}
}
