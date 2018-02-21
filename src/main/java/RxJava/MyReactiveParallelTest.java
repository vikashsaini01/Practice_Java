package RxJava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function3;
import io.reactivex.internal.schedulers.IoScheduler;

public class MyReactiveParallelTest {

	public static final double errorProbability = 1.0;

	public Observable<String> getObservableForPeople() {

		Observable<String> ob = Observable.create(emitter -> {
			emitter.onNext(emitStringWithDelay("Tarun"));
			emitter.onNext(emitStringWithDelay("Jatin"));
			emitter.onNext(emitStringWithDelay("Sachin"));

			emitter.onNext(emitStringWithDelay("Rahul"));

			if (Math.random() > errorProbability)
				emitter.onError(new Exception("Error in emit"));
			emitter.onNext(emitStringWithDelay("Kohli"));

			emitter.onNext(emitStringWithDelay("Yuvraj"));
			emitter.onNext(emitStringWithDelay("VVS Laxman"));
			emitter.onComplete();
		});

		return ob;

	}

	private String emitStringWithDelay(String str) throws InterruptedException {
		Thread.sleep(1500);
		return str;
	}

	public Observable<String> getObservableForColorWithDelays() {
		Observable<String> ob = Observable.create(emitter -> {
			emitter.onNext(emitStringWithDelay("Red"));
			emitter.onNext(emitStringWithDelay("Blue"));
			emitter.onNext(emitStringWithDelay("Green"));

			emitter.onNext(emitStringWithDelay("Orange"));

			if (Math.random() > errorProbability)
				emitter.onError(new Exception("Error in emit"));
			emitter.onNext(emitStringWithDelay("pink"));

			emitter.onNext(emitStringWithDelay("white"));
			emitter.onNext(emitStringWithDelay("Yellow"));
			emitter.onComplete();
		});

		return ob;
	}

	public Observable<String> getObservableForWeekdaysWithDelays() {
		Observable<String> ob = Observable.create(emitter -> {
			emitter.onNext(emitStringWithDelay("Monday"));
			emitter.onNext(emitStringWithDelay("Tuesday"));
			emitter.onNext(emitStringWithDelay("Wednesday"));

			emitter.onNext(emitStringWithDelay("Thursday"));

			if (Math.random() > errorProbability)
				emitter.onError(new Exception("Error in emit"));
			emitter.onNext(emitStringWithDelay("Friday"));

			emitter.onNext(emitStringWithDelay("Saturday"));
			emitter.onNext(emitStringWithDelay("Sunday"));
			emitter.onComplete();
		});

		return ob;
	}

	public Observer<String> getObserver() {
		return new Observer<String>() {

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
				System.out.println(t);

			}

			@Override
			public void onSubscribe(Disposable d) {
				System.out.println("Subscribe called now ");

			}
		};
	}

	public static Scheduler getScheduler() {
		IoScheduler ioScheduler = new IoScheduler();
		return ioScheduler;
	}

	public static void main(String[] str) throws InterruptedException {
		MyReactiveParallelTest myReactiveTest = new MyReactiveParallelTest();

		Observable<String> obPeople = myReactiveTest.getObservableForPeople().subscribeOn(getScheduler());
		Observable<String> obColor = myReactiveTest.getObservableForColorWithDelays().subscribeOn(getScheduler());
		Observable<String> obWeekdays = myReactiveTest.getObservableForWeekdaysWithDelays().subscribeOn(getScheduler());

		Observable<String> outputObservable = Observable.zip(obPeople, obColor, obWeekdays,
				new Function3<String, String, String, String>() {

					@Override
					public String apply(String t1, String t2, String t3) throws Exception {
						return t1 + " likes " + t2 + " on " + t3;
					}
				});

		outputObservable = outputObservable.subscribeOn(getScheduler());

		//outputObservable.subscribe(myReactiveTest.getObserver());
		outputObservable.blockingSubscribe(myReactiveTest.getObserver());

		Thread.sleep(10700);
		System.out.println("10.7 seconds over");

	}
}
