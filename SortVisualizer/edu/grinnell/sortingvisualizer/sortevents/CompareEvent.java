package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;

/* Compare Events that fire whenever an algorithm 
 * compares two elements of the array. 
 * Compare events are not emphasized, 
 * and their affected indices are the indices of the elements being compared. 
 * Applying a compare event does nothing to an array.
 */
public class CompareEvent<T> extends SortEvent<T>{
	/* constructor
	 * 
	 */
	public CompareEvent(T[] arr, ArrayList<Integer> affectedList) {
		super(false, arr, affectedList);
	}
}