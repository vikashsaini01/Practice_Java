package tesco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintLists {
	List<Integer> A = Arrays.asList(10, 1, 3, 9, 6);
	List<Integer> B = Arrays.asList(2, 3, 4);
	List<Integer> C = Arrays.asList(5, 6, 2, 3);
	List<Integer> D = Arrays.asList(4, 5);

	List<List<Integer>> data = new ArrayList<>(Arrays.asList(A, B, C, D));

	// Output expected – 10, 2, 5, 4, 1, 3, 6, 5, 3, 4, 2, 9, 3, 6

	int dataSize;
	int outIndex;
	int inIndex;
	boolean hopeForMore = false;

	public PrintLists() {
		init();
	}

	void init() {
		dataSize = data.size();
		outIndex = 0;
		inIndex = 0;
	}

	PrintLists nextOnClick() {
		boolean breakLoop = false;
		while (!breakLoop) {
			if (inIndex < data.get(outIndex).size()) {
				System.out.print(data.get(outIndex).get(inIndex) + ", ");
				breakLoop = true;
				hopeForMore = true;
			}

			outIndex++;
			if (outIndex >= dataSize) {
				if (hopeForMore == false) {
					System.out.println("No more data");
					outIndex--;
					return this;
				}
				outIndex = 0;
				hopeForMore = false;
				inIndex++;
			}
		}
		return this;
	}

	public static void main(String[] args) {

		PrintLists  printLists=new PrintLists().nextOnClick().nextOnClick().nextOnClick().nextOnClick().nextOnClick().nextOnClick()
				.nextOnClick().nextOnClick().nextOnClick().nextOnClick().nextOnClick().nextOnClick().nextOnClick()
				.nextOnClick().nextOnClick().nextOnClick().nextOnClick().nextOnClick().nextOnClick().nextOnClick();
		;
		printLists.data.get(2).add(34);
		printLists.data.get(2).add(35);
		printLists.data.get(0).add(36);
		printLists.data.get(3).add(37);
		
		printLists.nextOnClick();
		printLists.data.get(0).add(38);
		printLists.nextOnClick().nextOnClick().nextOnClick().nextOnClick().nextOnClick().nextOnClick();
		
	}

}
