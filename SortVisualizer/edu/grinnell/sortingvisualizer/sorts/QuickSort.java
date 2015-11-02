package edu.grinnell.sortingvisualizer.sorts;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort <T> {
	public static <T extends Comparable<? super T>> T[] BaseSort(T arr[], int left, int right){
		for(int i = left; i < right; i++){
			for(int j = i+1; j > left; j--){
				if(arr[j].compareTo(arr[j-1]) < 0){
					swap(arr, j, j-1);
				} else break;
			}
		}
		return arr;
	}

	public static <T extends Comparable<? super T>> void QuickSort(T[] arr){
		QuickSortHelper(arr, 0, arr.length-1);
	}

	public static <T extends Comparable<? super T>> void QuickSortHelper(T arr[],int left, int right){
		if(left >= right - 2){ //when there's no more than three elements in left
			BaseSort(arr, left, right); //sort the remaining array of length three
		}
		else {
			T pivot;
			int middle = (left + right)/2;
			//creating pivot according to finding median of first, middle, and last
			if(arr[right].compareTo(arr[left]) < 0){
				swap(arr, right, left);
			}
			if(arr[left].compareTo(arr[middle]) < 0){
				swap(arr, left, middle);
			}
			if(arr[middle].compareTo(arr[right]) < 0){
				swap(arr, right, middle);
			}
			pivot = arr[middle];
			swap(arr, middle, right); //bc "right" is greater than middle, 
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
					swap(arr, i, j);
				}
				swap(arr, right, i);
				QuickSortHelper(arr, left, i-1);
				QuickSortHelper(arr, i+1, right);
			}
		}
	}
	public static <T extends Comparable<? super T>> void swap(T arr[], int indexOne, int indexTwo){
		T temp = arr[indexOne];
		arr[indexOne] = arr[indexTwo];
		arr[indexTwo] = temp;
	}
}
