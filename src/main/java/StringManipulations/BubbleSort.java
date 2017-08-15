package StringManipulations;

import java.util.concurrent.ThreadLocalRandom;

public class BubbleSort {
	int[] numbers;

	BubbleSort(int size) {
		numbers = new int[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = ThreadLocalRandom.current().nextInt(1, size);
		}
	}

	private void disp() {
		for (int i = 0; i < numbers.length; i++)
			System.out.print(numbers[i] + ", ");
	}

	
	//Taking largest to end in each iteration
		public void bubbleSortByLargest() {
			for (int i = numbers.length-1; i >= 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					int temp;
					if (numbers[i] < numbers[j]) {
						temp = numbers[j];
						numbers[j] = numbers[i];
						numbers[i] = temp;
					}
				}
			}
		}
		
	
	//Bringing shortest first in each iteration
	public void bubbleSortByShortest() {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int temp;
				if (numbers[i] > numbers[j]) {
					temp = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = temp;
				}
			}
		}
	}
	
	public static void main(String[] str){
		BubbleSort bubbleSort = new BubbleSort(20);
		bubbleSort.disp();
		System.out.println("");
		bubbleSort.bubbleSortByShortest();
		bubbleSort.disp();
		System.out.println("");
		System.out.println("");
		
		
		BubbleSort bubbleSort1 = new BubbleSort(20);
		bubbleSort1.disp();
		System.out.println("");
		bubbleSort1.bubbleSortByLargest();
		bubbleSort1.disp();
		System.out.println("");
		System.out.println("");
	}
}