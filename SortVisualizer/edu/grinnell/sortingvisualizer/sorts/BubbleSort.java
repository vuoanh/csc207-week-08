package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;

public class BubbleSort{
	public static <T extends Comparable<? super T>> void BubbleSort(T[] arr){
		ArrayList<SortEvent> bubbleList = new ArrayList<SortEvent>(); 
		if (arr == null) {
			throw new IllegalArgumentException();
		}
		int min = 0;
		for (int i = 0; i< arr.length; i++) {
			for (int j = i+1 ; j < arr.length; j++) {
				ArrayList<Integer> indArr = new ArrayList<Integer>();
				indArr.add(min);
				indArr.add(j);
				SortEvent<T> compareEvent = new CompareEvent<T>(arr, indArr);
				bubbleList.add(compareEvent);
				if (arr[min].compareTo(arr[j]) < 0) {
					min = j;
				}
			}
			ArrayList<Integer> indArr = new ArrayList<Integer>();
			indArr.add(min);
			indArr.add(i);
			SortEvent<T> compareEvent = new CompareEvent<T>(arr, indArr);
			SortEvent<T> swapEvent = new SwapEvent<T>(arr, indArr);
			swapEvent.apply(arr);
			bubbleList.add(swapEvent);
		}
	}
}

