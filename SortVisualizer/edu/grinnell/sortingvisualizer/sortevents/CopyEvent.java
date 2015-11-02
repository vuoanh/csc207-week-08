package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
/* Copy Events that fire whenever an algorithm copies an element into an index of the array. 
 * Copy events are emphasized, and the affected index is the destination of the copy. 
 * Applying a copy event performs the copy of the recorded value into the array.
 */

public class CopyEvent<T> extends SwapEvent<T>{
	private T value;
	/* constructor */
	public CopyEvent(T[] arr, ArrayList<Integer> list, T value) {
		super(arr, list);
		this.value = value;
	}
	
	/* Copies the recorded value into the array.
	 * @arr : an array of objects typed T
	 */
	@Override
	public void apply(T[] arr){
		int index = getAffectedIndices().get(1);
		arr[index] = this.value;
	}
}
