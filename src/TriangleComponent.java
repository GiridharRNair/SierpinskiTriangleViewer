/**
* The TriangleComponent class displays a Sierpinski Triangle by drawing 
* a series of triangles inside another triangle using recursion.
* @author Ms. Bailey
* Collaborators: Giridhar Nair
* Teacher Name: Ms. Bailey
* Period: 2
* Due Date: 03-16 -22
*/
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JComponent;

public class TriangleComponent extends JComponent
{
	
	// constant class array to hold progression of colors
	private static final Color LAVENDER = new Color(204, 153, 255);
	private static final Color PURPLE = new Color(153, 0, 255);
	private static final Color[] colors = {LAVENDER, Color.cyan, Color.darkGray, Color.blue, 
		PURPLE, Color.pink, Color.black, Color.lightGray};
		
		
	private static final int BORDER = 5;
		
	// Graphics object used for drawing
	private Graphics2D gr;
	
	/** Draw the triangles
	 *  @param g the Graphics object for drawing in this component
	 */
	@Override
	public void paintComponent(Graphics g) 
	{
		gr = (Graphics2D) g;
		// place first call to your drawTriangle method here
		drawTriangle(getWidth() / 2, BORDER, BORDER, getHeight() - BORDER, 
		getWidth() - BORDER, getHeight() - BORDER, 0);
	}
	
	/** Calculates and returns the number of students in a requested
	* grade level. If requested, only honors students are counted.
	* @param x1 the cordinate of the first x value
	* @param y1 the cordinate of the first y value
	* @param x2 the cordinate of the second x value
	* @param y2 the cordinate of the second y value
	* @param x3 the cordinate of the third x value
	* @param y3 the cordinate of the third y value
	* @param colorIndex the index for the array of colors,
	* will be cycled through every time the recursion advances.
	*/
	private void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int colorIndex)
	{
	   	int xPoints[] = {x1, x2, x3};
    	int yPoints[] = {y1, y2, y3};
   		Polygon triangle = new Polygon(xPoints, yPoints, 3);
   		gr.setColor(colors[colorIndex]);
   		gr.fillPolygon(triangle);
   		if((x3-x1) < 2)
   		{
   			return; 
    	}
    	if(colorIndex > 6)
    	{
        	colorIndex = 0;
    	}
        colorIndex++;
        int newx1 = (x1+x2)/2;
        int newy1 = (y1+y2)/2;
        int newx2 = (x2+x3)/2;
        int newy2 = (y2+y3)/2;
        int newx3 = (x1+x3)/2;
        int newy3 = (y1+y3)/2;
        drawTriangle(x1, y1, newx1, newy1,newx3, newy3, colorIndex); 
        drawTriangle(newx1, newy1, x2, y2,newx2, newy2, colorIndex); 
        drawTriangle(newx3, newy3, newx2, newy2, x3, y3, colorIndex);
    }	
}
