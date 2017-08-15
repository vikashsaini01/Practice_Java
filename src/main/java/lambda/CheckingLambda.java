package lambda;

interface MyValue {
	int getValue();
}

interface MyValue1 {
	double getValue(double x);
}

interface MyValue2 {
	void getValue(String x);
}

interface MyValue3<T> {
	T getValue(T x);
}

public class CheckingLambda {
	public static void main(String[] ag) {
		MyValue myValue;
		MyValue1 myValue1;
		myValue = () -> 122;
		System.out.println(myValue.getValue());
		myValue = () -> (122 * 3) / 4;
		System.out.println(myValue.getValue());
		myValue1 = (x) -> (122 * 3) / x;
		System.out.println(myValue1.getValue(4));

		myValue1 = (x) -> {
			System.out.println(x);
			return (122 * 4) / x;
		};
		System.out.println(myValue1.getValue(4));

		MyValue2 myValue2 = (x) -> System.out.println(x);
		;
		myValue2.getValue("Hello");

		MyValue3<String> myValue3 = (x) -> {
			System.out.println(x);
			return x;
		};
		myValue3.getValue("Hi");

		MyValue3<Integer> myValue3_1 = (x) -> {
			System.out.println(x);
			return x * x;
		};
		System.out.println(myValue3_1.getValue(8));

		CheckingLambda checkingLambda = new CheckingLambda();
		checkingLambda.doSomething((x) -> {
			System.out.println(x);
			return x * x * x;
		}, 11);
	}

	public void doSomething(MyValue3<Integer> myValue3, int x) {
		System.out.println("do something");
		System.out.println(myValue3.getValue(x));;
	}
}
