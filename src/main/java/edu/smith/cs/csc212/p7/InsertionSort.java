package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class InsertionSort {
	public static void insertionSort(ListADT<Integer> input) {
		ListADT<Integer> sorted = new JavaList<>();
		sorted.addBack(input.getFront());
		input.removeFront();
		for(Integer i : input) {
			for(int j = 0; i < sorted.size(); i++) {
				if (i < sorted.getIndex(j)) {
					sorted.addIndex(j, i);
				}
			}
			input.removeFront();
		}
		for(Integer i : sorted) {
			input.addBack(i);
		}
	}
}
