package edu.smith.cs.csc212.p7;

import java.util.Arrays;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class MergeSort {
	public static ListADT<Integer> combineHelper(ListADT<Integer> list1, ListADT<Integer> list2){
		ListADT<Integer> merged = new JavaList<Integer>();
		while (list1.size() > 0 && list2.size() > 0) {
			if (list1.getFront() <= list2.getFront()) {
				merged.addBack(list1.removeFront());
			}
			else {
				merged.addBack(list2.removeFront());
			}
		}
		if (list1.size() != 0) {
			for (Integer i : list1) {
				merged.addBack(i);
			}
		}
		if (list2.size() != 0) {
			for (Integer i : list2) {
				merged.addBack(i);
			}
		}
		return merged;
	}
	
	public static ListADT<Integer> recursiveMergeSort(ListADT<Integer> input){
		if (input.size() <= 1) {
			return input;
		}
		ListADT<Integer> merged = new JavaList<Integer>();
		ListADT<Integer> half1 = input.slice(0, input.size()/2);
		ListADT<Integer> half2 =  input.slice(input.size()/2, input.size());
		half1 = recursiveMergeSort(half1);
		half2 = recursiveMergeSort(half2);
		merged = combineHelper(half1, half2);
		return merged;
	}
	
	public static ListADT<Integer> iterativeMergeSort(ListADT<Integer> input){
		ListADT<Integer> merged = new JavaList<Integer>();
		DoublyLinkedList<ListADT<Integer>> workQueue = new DoublyLinkedList<ListADT<Integer>>();
		for(Integer i : input) {
			ListADT<Integer> item = new JavaList<Integer>(Arrays.asList(i));
			workQueue.addBack(item);
		}
		while(workQueue.size() > 1) {
			merged = combineHelper(workQueue.removeFront(), workQueue.removeFront());
			workQueue.addBack(merged);
		}
		merged = workQueue.getFront();
		return merged;
	}

}
