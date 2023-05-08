/*
 *	TriangleViewer.java
 *	Constructs frame with a component in which a triangle pattern will be drawn
 */

import javax.swing.JFrame;

public class TriangleViewer 
{
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 400;

	// Set-up the GUI
	public static void main( String[] args) 
	{

 		// Instantiate and define JFrame
 		JFrame frame = new JFrame();
 		
 		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
 		frame.setTitle("Sierpinski's Triangles");
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		// Draw the triangles
 		TriangleComponent component = new TriangleComponent();
 		frame.add(component);
 		frame.setVisible(true);
	}
}
