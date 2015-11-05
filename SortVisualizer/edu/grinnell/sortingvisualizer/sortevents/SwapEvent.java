package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
/* Swap Events that fire whenever an algorithm swaps elements of the array. 
 * Swap events are emphasized, 
 * and their affected indices are the indices of the elements being swapped. 
 * Applying a swap event swaps the recorded indices of the array.
 */
public class SwapEvent<T> extends SortEvent<T> {
	/* constructor */
	public SwapEvent(T[] arr, ArrayList<SortEvent> list, int index1, int index2) {
		super(true, new ArrayList<Integer>());
		this.getAffectedIndices().add(index1);
		this.getAffectedIndices().add(index2);
		apply(arr);
		list.add(this);
	}
	
	/* applies this sort event to the given array.
	 * @arr : an array of objects typed T
	 */
	@Override
	public void apply(T[] arr){
		int indexOne = getAffectedIndices().get(0);
		int indexTwo = getAffectedIndices().get(1);
		T temp = arr[indexOne]; 
		arr[indexOne] = arr[indexTwo];
		arr[indexTwo] = temp;
	}
}
