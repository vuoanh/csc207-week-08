package edu.grinnell.sortingvisualizer.sorts;
import java.util.ArrayList;
import java.util.Arrays;

import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;

public class InsertionSort {
	public static <T extends Comparable<? super T>> void InsertionSort(T arr[]){
		ArrayList<SortEvent> insertList = new ArrayList<SortEvent>(); 
		for(int i = 0; i < arr.length-1; i++){
			for(int j = i+1; j > 0; j--){
				ArrayList<Integer> indArr = new ArrayList<Integer>();
				indArr.add(j);
				indArr.add(j-1);
				SortEvent<T> compareEvent = new CompareEvent<T>(arr, indArr);
				insertList.add(compareEvent);
				if(arr[j].compareTo(arr[j-1]) <0){
					T temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				} else break;
			}
		}
	}
}

