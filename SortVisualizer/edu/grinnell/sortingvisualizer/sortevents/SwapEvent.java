package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
/* Swap Events that fire whenever an algorithm swaps elements of the array. 
 * Swap events are emphasized, 
 * and their affected indices are the indices of the elements being swapped. 
 * Applying a swap event swaps the recorded indices of the array.
 */
public class SwapEvent<T> extends SortEvent<T> {
	/* constructor */
	public SwapEvent(T[] arr, ArrayList<Integer> affectedList) {
		super(true, arr, affectedList);
	}
	
	/* applies this sort event to the given array.
	 * @arr : an array of objects typed T
	 */
	@Override
	public void apply(T[] arr){
		int indexOne = getAffectedIndices().get(1);
		int indexTwo = getAffectedIndices().get(2);
		T temp = arr[indexOne]; 
		arr[indexOne] = arr[indexTwo];
		arr[indexTwo] = temp;
	}
}
