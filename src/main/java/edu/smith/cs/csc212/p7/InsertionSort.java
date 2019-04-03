package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class InsertionSort {
	public static void insertionSort(ListADT<Integer> input) {
		ListADT<Integer> sorted = new JavaList<>();
		sorted.addFront(input.getFront());
		input.removeFront();
		while (input.size() > 0) {
			Integer toSort = input.getFront();
			int count = 0;
			for(Integer i : sorted) {
				if ((count == 0 || toSort > sorted.getIndex(count - 1)) && toSort <= i) {
					sorted.addIndex(count, toSort);
					break;
				}
				else if (count == sorted.size()-1) {
					sorted.addBack(i);
					break;
				}
				count ++;
			}
			input.removeFront();
		}
		for(Integer i : sorted) {
			input.addBack(i);
		}
	}
}
