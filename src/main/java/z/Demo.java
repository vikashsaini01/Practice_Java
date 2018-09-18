package z;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Demo {
	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}

		Predicate<Integer> filter = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		};
		Stream<Integer> sequencialStream = numbers.stream();
		long startTime = System.currentTimeMillis();
		List<Integer> result = sequencialStream.filter(filter).collect(Collectors.toList());
		System.out.println("TOtal Time Sequencial:" + (System.currentTimeMillis() - startTime));
		// System.out.println("Result Seq ->" + result);

		Stream<Integer> parallelStream = numbers.parallelStream();
		long startTime1 = System.currentTimeMillis();
		result = parallelStream.filter(filter).collect(Collectors.toList());
		System.out.println("TOtal Time Parallel:" + (System.currentTimeMillis() - startTime1));
		// System.out.println("Result Par ->" + result);
	}

}