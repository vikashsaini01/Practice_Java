package z;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

	boolean do1() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("do1");
		return true;
	}

	boolean do2() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("do2");
		return true;
	}

	boolean do3() {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("do3");
		return true;
	}

	boolean do4() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("do4");
		return true;
	}

	void doIt() {
		System.out.println((LocalDateTime.now()));
		CompletableFuture<Void> setAll = CompletableFuture.allOf(CompletableFuture.supplyAsync(() -> do1()),
				CompletableFuture.supplyAsync(() -> do2()), CompletableFuture.supplyAsync(() -> do3()),
				CompletableFuture.supplyAsync(() -> do4()));

		try {
			System.out.println(LocalDateTime.now().toString());
			setAll.get();
			System.out.println(LocalDateTime.now().toString());
			
			do1();do2();do3();do4();
			System.out.println(LocalDateTime.now().toString());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new CompletableFutureTest().doIt();
	}
}
