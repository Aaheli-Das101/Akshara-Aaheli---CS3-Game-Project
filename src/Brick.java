import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Complete the Brick class.
 */

public class Brick extends Canvas
{
	//these are instance variables
	private int x, y, w, h;

	public Brick()
	{
		//complete this constructor
	}
	
	public Brick( int ex, int wy, int wd, int ht)
	{
		//complete this constructor
	}
	
	//Brick and any class extending Brick 
	//will inherit these complete methods
	public int getX( ){ return x; }
	public void setX( int ex ){ x = ex; }
	public int getY( ){ return y; }
	public void setY( int wy ){ y = wy; }
	public int getW(){ return w; }
	public int getH(){ return h; }
	
	//write the code to see if this Brick 
	//intersects with the other Brick
	public boolean intersects( Brick other )
	{
		/* Rectangle Help
		 * 		This link has help docs for Rectangle
		 *		https://docs.oracle.com/javase/8/docs/api/java/awt/Rectangle.html
		 *		make new Rectangle, using this Brick's x,y,w,h
		 *		make new Rectangle, using the other Bricks's x,y,w,h
		 *		return if the two Rectangles intersect, use the Rectangle's intersects method.
		 */
		 
		return false;
	}

	//code to draw the Brick will go here
	public void paint( Graphics window )
	{
		window.drawString("Brick Class ", 50, 150 );

		//Draw the Brick with graphics methods
		//or use an Image
		
		
		//PICK ONE -  YOU CANNOT DO BOTH!!!!
		
		
		window.setColor(Color.RED);
		window.fillRect(getX(), getY(), getW(), getH());
		window.setColor(Color.BLACK);
		window.drawRect(getX(), getY(), getW(), getH());
		*/

		//Find an Image for the Brick.
		/*
		Graphics2D g2 = (Graphics2D) window;
		Image img1 = Toolkit.getDefaultToolkit().getImage("brick.png"); //use .gif or .png, you can choose the image
		g2.drawImage(img1, getX(), getY(), getW(), getH(), this);
		*/
	}
}