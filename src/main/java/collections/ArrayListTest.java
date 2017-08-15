package collections;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] arg)
	{
		ArrayList<String> arr = new ArrayList<>();
		
		arr.add("One");
		arr.add("two");
		arr.add("three");
		arr.add("four");
		arr.add("five");
		arr.add(2, "2");
		
		System.out.println(arr);
	}
}
