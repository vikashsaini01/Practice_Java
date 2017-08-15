package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

class MyCompartor implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}

}
class Human{}
class Person  extends Human implements Comparable<Person>{
	String name;
	int number;

	Person(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", number=" + number + "]";
	}

	@Override
	public int compareTo(Person arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
class Student extends Person{
	Student(String name, int number) {
		super(name, number);		
	}	
}

class LastNameComparator implements Comparator<Person> {
	@Override
	public int compare(Person arg0, Person arg1) {
		return arg0.getName().substring(arg0.getName().lastIndexOf(" ")).compareTo(arg1.getName().substring(arg1.getName().lastIndexOf(" ")));
	}
}
class NameComparator implements Comparator<Person> {
	@Override
	public int compare(Person arg0, Person arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}
}
class NumberComparator implements Comparator<Person> {
	@Override
	public int compare(Person arg0, Person arg1) {
		return ((Integer)arg0.getNumber()).compareTo(arg1.getNumber());
	}
}

public class ComparetorExample {

	public void display() {
		TreeSet<String> treeSet = new TreeSet<>(new MyCompartor().reversed().reversed());
		treeSet.add("A");
		treeSet.add("B");
		treeSet.add("C");
		treeSet.add("D");
		treeSet.add("E");
		treeSet.add("F");
		System.out.println(treeSet);
	}
	
	public ArrayList<Person> display1() {
		TreeSet<Person> treeSet = new TreeSet<>(new LastNameComparator().thenComparing(new NameComparator()).thenComparing(new NumberComparator()));
		treeSet.add(new Person("Abc Cde", 11));
		treeSet.add(new Person("Abc Bde", 11));
		treeSet.add(new Person("Bbc Cde", 11));
		treeSet.add(new Person("Bbc Cdef", 12));	
		treeSet.add(new Person("Bbc Cdef", 11));
		System.out.println(treeSet);
		
		
		ArrayList<Person> arrayList = new ArrayList<>();
		arrayList.add(new Person("Abc Cde", 11));
		arrayList.add(new Person("Abc Bde", 11));
		arrayList.add(new Person("Bbc Cde", 11));
		arrayList.add(new Person("Bbc Cdef", 12));	
		arrayList.add(new Person("Bbc Cdef", 11));
		
		return arrayList;
	}

	public void process(){
		ArrayList<Person> arrayList=display1();
		/**** Here arrayList of type person can be compared only with function compare that is accepting parameter of type either person or its super 
		 * class. Because a subclass compare function cant be called by the super class reference. That means if any child class of person is implementing 
		 * Comparable (or to be specific overriding compare) that compare function wont be of any use, Because when the binary search tries to find the 
		 * element using compare method of person class, it wont find the method as it is in child class.
		 * To use compare method on Person class it must be present in Person class or its super class.
		 */
		int x = Collections.binarySearch(arrayList, new Person("a",1));
		
		Collections.checkedCollection(arrayList, Person.class);
		Collections.checkedList(arrayList, Person.class);
		Collections.singleton(new Person("sa", 12)); //.add(new Person("ds", 3)); UnsupportedMethodException 
		System.out.println(x);
		
		Collections.emptySet();
		
		
		
		
		int[] arr = new int[]{1,2,3,4,5,6,7};
		
		System.out.println(Arrays.toString(Arrays.copyOf(arr, 4)));
		System.out.println(Arrays.toString(Arrays.copyOf(arr, 7)));
		System.out.println(Arrays.toString(Arrays.copyOf(arr, 17)));
	}

	public static void main(String[] ar) {
		new ComparetorExample().process();
	}
}
