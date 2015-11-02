package edu.grinnell.sortingvisualizer.sorts;
public class SelectionSort {
	public static <T extends Comparable<? super T>> void SelectionSort(T[] arr) {
		SelectionSortHelper(arr, 0, arr.length);
	}
	
	public static<T extends Comparable<? super T>> void SelectionSortHelper(T[] arr, int low, int high){
		if (low == high){
		return;
		} else {
			T min = arr[low];
			int minInd = low;
			for (int i = low + 1; i < high; i++) {
				if (arr[i].compareTo(min) < 0) {
					min = arr[i];
					minInd = i;
				}
			}
			QuickSort.swap(arr, minInd, low);
			SelectionSortHelper(arr, low + 1, high);
		}
	}
}
