import javax.swing.JFrame;

public class SortingVisualizer {
	JFrame Frame = new JFrame();
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		ArrayPanel panel = new ArrayPanel( new int[] {0,1,2,3,4,5});
	
	frame.setTitle("Sorting Visualizer");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);
	frame.pack();
	frame.setVisible(true);
	}
}
