package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] sr){
		List<Integer> integers = new ArrayList<>(); 
		integers.add((int)(Math.random()*100));
		integers.add((int)(Math.random()*100));
		integers.add((int)(Math.random()*100));
		integers.add((int)(Math.random()*100));
		integers.add((int)(Math.random()*100));
		integers.add((int)(Math.random()*100));
		System.out.println("Initial List " + integers);
		
		Stream<Integer> stream= integers.stream();
		Optional<Integer> value = stream.min(Integer::compare) ;
		System.out.println("Min value: "+ (value.isPresent()? value.get(): "none"));
		
		value = integers.stream().max(Integer::compare) ;
		System.out.println("Max value: "+ (value.isPresent()? value.get(): "none"));
		
		stream = integers.stream().sorted(Integer::compare);
		
		stream.forEach((X)->System.out.println("Hi! I am "+ X)); 
		
		
	}
}
