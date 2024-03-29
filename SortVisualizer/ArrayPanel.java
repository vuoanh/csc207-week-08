import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

public class ArrayPanel<Integer> extends JPanel{
	private Integer[] arr;
	private int width;
	private int height;
	private int max;
	private ArrayList<Integer> indices;
	private static final long serialVersionUID = 1L;
	public ArrayPanel(Integer[] arr, 
			int width, int height, int max, ArrayList<Integer> indices) {
		this.arr =  (Integer[]) arr;
		this.width = width;
		this.height = height;
		this.max = max;
		this.indices = indices;
		setPreferredSize(new Dimension(width,height));	
	}
	
	public void paintComponent(Graphics g) {
		int len = arr.length;
		int regW = width/len;
		int regHCoor = height/max;
		Color Color = new Color(50, 50,50); 
		Color indexColor = new Color(204, 255, 204); 
		for (int i = 0; i < len; i++) {
			g.setColor(Color);
			g.fillRect(i*regW, height - regHCoor * (int)(arr[i]),
					regW, regHCoor * (int)(arr[i]));
		}
		g.setColor(indexColor);
		for(int j = 0; j < indices.size(); j++){
			g.fillRect((int) indices.get(j) * regW, 
					height - regHCoor * (int)(arr[(int) indices.get(j)]),
					regW, regHCoor * (int)(arr[(int) indices.get(j)]));
		}
	}
}
