package edu.grinnell.sortingvisualizer.sortevents;
import java.util.ArrayList;
import java.util.List;
public class SortEvent<T> {
	private boolean emphasized = false;
	private T[] arr;
	private ArrayList<Integer> affectedList;
	
	public SortEvent(boolean emphasized, T[] arr, ArrayList<Integer> affectedList){
		this.emphasized = emphasized;
		this.arr = (T[]) arr;
		this.affectedList = affectedList;
	}
	
	/* applies this sort event to the given array.
	 * @arr : an array of objects typed T
	 */
	public void apply(T[] arr){
		return;
	}
	
	/* returns a list containing all of the array indices that this event affects.
	 * 
	 */
	public ArrayList<Integer> getAffectedIndices(){
		return this.affectedList;
	}
	
	/* return true if this event should be emphasized by the visualizer/audibilizer.
	 */
	public boolean isEmphasized(){
		return this.emphasized;
	}
}
