
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
public class ArrayPanel extends JPanel{
	private int[] arr;
	private static final long serialVersionUID = 1L;
	public ArrayPanel(int[] arr) {
		this.arr = arr;
		setPreferredSize(new Dimension(400,500));	
	}

	public void paintComponent(Graphics g) {
		int len = arr.length;
		int regW = 400/len;
		for (int i = 0; i < len; i++) {
			Color Color = new Color(200 - 20 * i, 200 - 20 * i, 200 - 20 * i); 
			g.setColor(Color);
			g.fillRect(i*regW,500-20*arr[i],regW,20*arr[i]);
		}
	}
}
