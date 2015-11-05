import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFrame;

import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sorts.Sorts;

public class SortingVisualization {

	public static final Integer[] bMinorPentatonicNotes =
			new Integer[] { 46, 49, 51, 53, 56, 58, 61, 63
					, 65, 68, 70, 73, 75, 78, 82, 85, 87 };
	public static final Integer[] chromaticNotes =
			new Integer[] { 40, 41, 42, 43, 44, 45, 46, 47, 48, 49
					, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59
					, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69
					, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79 };

	public static Scale chooseScale(String s) throws MidiUnavailableException{
		if(s == "chromaticNotes"){
			return new Scale(chromaticNotes);
		}
		else{
			return new Scale(bMinorPentatonicNotes);
		}
	}

	public static <T extends Comparable<? super T>> void main(String args[])throws MidiUnavailableException{
		JFrame Frame = new JFrame();

		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);
		int fps = Integer.parseInt(args[2]);
		String sortingAlgo = args[3];
		String inputScale = args[4];

		Scale scale = chooseScale(inputScale);
		// Prompt user input to get the Integer, width, and height

		Integer[] arr = {49, 15, 23, 41, 13, 8, 9, 45, 24, 47, 21, 40, 33,
				43, 26, 35, 38, 34, 50, 19, 30, 28, 14, 48, 20, 17, 4, 39, 5, 3, 7,
				29, 22, 11, 46, 2, 12, 44, 18, 16, 1, 10, 6, 31, 37, 42, 25, 32, 36, 27}; 
		ArrayList<Integer> affectedIndices = new ArrayList<Integer>();

		// Create the array used in sound sorting
		Integer[] displayArr = arr.clone();
		// Create a list of SortEvent after sorting the arr
		ArrayList<SortEvent> eventList = new ArrayList<SortEvent>();

		switch(sortingAlgo){
		case "insertion": eventList = Sorts.InsertionSort(arr);
		break;
		case "bubble": eventList = Sorts.BubbleSort(arr);
		break;
		case "merge": eventList = Sorts.mergeSortHelper(arr, 0, arr.length-1);
		break;
		case "quick": eventList = Sorts.quickSort(arr);
		break;
		case "selection": eventList = Sorts.SelectionSort(arr);
		break;
		default:
			break;
		}

		// Initiate an Iterator
		Iterator<SortEvent> iter = eventList.iterator();

		// Make a frame and panel
		JFrame frame = new JFrame(); // get a new frame
		frame.setTitle("Sorting Visualizer"); // set title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close when there is no task to do
		frame.setResizable(false); // Disables resizing of the frame
		ArrayPanel panel = new ArrayPanel(displayArr, width, height, arr[arr.length - 1], affectedIndices);
		frame.add(panel); // add the panel into frame to display it
		frame.pack();
		frame.setVisible(true);

		// Create timer and timer task object to repeatedly run the sorting display
		TimerTask task = new TimerTask() {
			@Override
			public void run(){
				if (iter.hasNext()){
					SortEvent sortEvent = iter.next();
					ArrayList<Integer> tempList = sortEvent.getAffectedIndices();
					for(int i = 0; i < tempList.size(); i++){
						scale.playNote(tempList.get(i), sortEvent.isEmphasized());
					}
					sortEvent.apply(displayArr);
					affectedIndices.clear();
					for(int i = 0; i < tempList.size(); i++){
						affectedIndices.add(tempList.get(i));
					}
					panel.repaint();

				}
				else cancel();
			}
		};
		Timer tasks = new Timer();
		tasks.schedule(task, 0, 1000/fps);

	}
}
