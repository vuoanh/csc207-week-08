package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;

import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvent;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;

public class Sorts{
	/* Given a list of SortEvent objects and an array of Ts, 
	 * applies those events to the array in-order. */
	public <T> void eventSort(ArrayList<SortEvent> eventList, T[] arr){
		int arrLength = arr.length;
		int listSize = eventList.size();
		for(int i = 0; i < listSize; i++){
			eventList.get(i).apply(arr);
		}
	}

	public static <T extends Comparable<? super T>> ArrayList<SortEvent> BubbleSort(T[] arr){
		ArrayList<SortEvent> bubbleList = new ArrayList<SortEvent>(); 
		if (arr == null) {
			throw new IllegalArgumentException();
		}
		int k = 0;
		for (int i = arr.length; i >= 0; i--) {
			for (int j = 0 ; j < i - 1; j++) {
				k = j + 1;
				SortEvent<T> compareEvent = new CompareEvent<T>(bubbleList,k, j);
				if (arr[k].compareTo(arr[j]) < 0) {
					SortEvent<T> swapEvent = new SwapEvent<T>(arr, bubbleList,k,j);
				}
			}
		}
		return bubbleList;
	}

	public static <T extends Comparable<? super T>> ArrayList<SortEvent> InsertionSort(T arr[]){
		ArrayList<SortEvent> insertList = new ArrayList<SortEvent>(); 
		for(int i = 0; i < arr.length-1; i++){
			for(int j = i+1; j > 0; j--){
				SortEvent<T> compareEvent = new CompareEvent<T>(insertList,j, j-1);
				// compare event
				if(arr[j].compareTo(arr[j-1]) <0){
					// swap jth and (j-1)th element of the list
					SortEvent<T> swapEvent = new SwapEvent<T>(arr, insertList,j, j-1);
				} else break;
			}
		}
		return insertList;
	}

	/* Helper mergeSort for mergeSort method. 
	 * Recursively devide the array into left and right sub arrays
	 * Then, recursively merge left and right sub arrays by using merge method
	 *  */
	public static <T extends Comparable<? super T>> ArrayList<SortEvent> mergeSortHelper(T arr[], int lower, 
			int upper){
		ArrayList<SortEvent> mergeList = new ArrayList<SortEvent>();
		T[] tmpArr = (T[]) new Comparable[arr.length];
		if (upper > lower) {
			int mid = lower + (upper - lower) /2;
			int leftPos = lower;
			int rightPos = mid + 1;
			int leftEnd = rightPos -1;
			int rightEnd = upper;
			int tmpPos = leftPos;
			mergeSortHelper(arr, lower, mid);
			mergeSortHelper(arr, mid+1, upper);
			
			// Compare first element of each of left and right sub arrays.
			// Copy the smaller element to outArr
			while(leftPos <= leftEnd && rightPos <= rightEnd){
				SortEvent<T> compareEvent = new CompareEvent<T>(mergeList,leftPos, rightPos);
				// compare Event
				if (arr[leftPos].compareTo(arr[rightPos]) < 0){
					tmpArr[tmpPos++] = arr[leftPos++];
				}
				else {
					tmpArr[tmpPos++] = arr[rightPos++];
				}
			}
			// if right sub array is out of element
			while(leftPos <= leftEnd){
				tmpArr[tmpPos++] = arr[leftPos++];
			}
			while(rightPos <= rightEnd){
				tmpArr[tmpPos++] = arr[rightPos++];
			}
			// Copy outArr back to arr
			for(int i = 0; i < arr.length; i++){
				//copy event
				SortEvent<T> copyEvent = new CopyEvent<T>(arr,mergeList,i, tmpArr[i]);
			}
		}
		return mergeList;
	}
	public static <T extends Comparable<? super T>> ArrayList<SortEvent> mergeSort(T arr[]){
		return mergeSortHelper(arr, 0, arr.length-1);
	}

	private static ArrayList<SortEvent> quickList;

	public static <T extends Comparable<? super T>> T[] BaseSort(T arr[], int left, int right){
		for(int i = left; i < right; i++){
			for(int j = i+1; j > left; j--){
				SortEvent<T> compareEvent = new CompareEvent<T>(quickList, j ,j-1);
				if(arr[j].compareTo(arr[j-1]) < 0){

					// swap event
					SortEvent<T> swapEvent = new SwapEvent<T>(arr,quickList, j, j-1);
				} else break;
			}
		}
		return arr;
	}

	public static <T extends Comparable<? super T>> ArrayList<SortEvent> quickSort(T[] arr){
		QuickSortHelper(arr, 0, arr.length-1);
		return quickList;
	}

	public static <T extends Comparable<? super T>> void QuickSortHelper(T arr[],int left, int right){
		if(left >= right - 2){ //when there's no more than three elements in left
			BaseSort(arr, left, right); //sort the remaining array of length three
		}
		else {
			T pivot;
			int middle = (left + right)/2;
			//creating pivot according to finding median of first, middle, and last
			// compare Event
			SortEvent<T> compareEvent = new CompareEvent<T>(quickList, right, left);
			if(arr[right].compareTo(arr[left]) < 0){
				SortEvent<T> swapEvent = new SwapEvent<T>(arr,quickList, right, left);
			}
			SortEvent<T> compareEvent1 = new CompareEvent<T>(quickList, right, left);
			// compare Event
			if(arr[left].compareTo(arr[middle]) < 0){
				SortEvent<T> swapEvent = new SwapEvent<T>(arr,quickList, left, middle);
			}
			SortEvent<T> compareEvent2 = new CompareEvent<T>(quickList,middle, left);
			// compare Event
			if(arr[middle].compareTo(arr[right]) < 0){
				SortEvent<T> swapEvent = new SwapEvent<T>(arr, quickList, right, middle);
			}
			pivot = arr[middle];

			//swap event
			SortEvent<T> swapEvent = new SwapEvent<T>(arr, quickList, middle,right);
			//bc "right" is greater than middle, 
			//swap middle to the index before right to create pivot
			//go through array and swap
			//i = low && j = high
			int i = left;
			int j = right;
			while(i < j){
				//increments i until it is untrue (fixes i to an index)
				while(arr[++i].compareTo(pivot) < 0){
					//decrements j until it is untrue (fixes j to an index)
					while(arr[--j].compareTo(pivot) > 0); 
					if(i >= j){
						break; //stop the "pointers"
					}
					// swap event
					SortEvent<T> swapEvent1 = new SwapEvent<T>(arr, quickList,i,j);
				}
				// swap event
				SortEvent<T> swapEvent2 = new SwapEvent<T>(arr, quickList,right, i);
				QuickSortHelper(arr, left, i-1);
				QuickSortHelper(arr, i+1, right);
			}
		}
	}

	public static<T extends Comparable<? super T>> ArrayList<SortEvent> SelectionSort(T[] arr){
		ArrayList<SortEvent> selectionList = new ArrayList<SortEvent>();
		int length = arr.length;
		int i, j, pos, temp;
		for (i = 0; i < length - 1; i++) {
			pos = i;
			for(j = i+1; j < length; j++){
				SortEvent<T> compareEvent = new CompareEvent<T>(selectionList,j,pos);
				if(arr[j].compareTo(arr[pos]) < 0){
					pos = j;
				}
			}
			// swap event
			SortEvent<T> swapEvent = new SwapEvent<T>(arr,selectionList,i,pos);
		}
		return selectionList;

	}

}

