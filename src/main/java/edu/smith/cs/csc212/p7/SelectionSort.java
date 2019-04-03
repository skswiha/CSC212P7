package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class SelectionSort {
	public static void selectionSort(ListADT<Integer> input) {
		ListADT<Integer> sorted = new JavaList<>();
		while(input.size()> 0) {
			Integer smallest = input.getFront();
			int count = 0;
			int smallestAt = 0;
			for(Integer i : input) {
				if(i < smallest) {
					smallest = i;
					smallestAt = count;
				}
				count++;
			}
			sorted.addBack(smallest);
			input.removeIndex(smallestAt);
		}
		for(Integer i : sorted) {
			input.addBack(i);
		}
	}		
}
