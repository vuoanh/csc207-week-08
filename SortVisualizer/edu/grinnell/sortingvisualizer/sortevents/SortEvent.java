package edu.grinnell.sortingvisualizer.sortevents;
import java.util.ArrayList;
import java.util.List;
public class SortEvent<T> {
	private boolean emphasized = false;
	private ArrayList<Integer> affectedList;
	
	public SortEvent(boolean emphasized, ArrayList<Integer> affectedList){
		this.emphasized = emphasized;
		this.affectedList = affectedList;
		
	}
	
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
