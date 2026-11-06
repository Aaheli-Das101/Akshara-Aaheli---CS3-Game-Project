import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Complete the Paddle class.
 */
 
public class User extends Brick
{
	private int speed; // a paddle has to have a speed to make it move
	
	public User( int ex, int wy, int wd, int ht, int sp)
	{
		//write the code for the Paddle constructor
		//must have a super constructor call
		//super call must be first
	}
	
	public void moveLeft()
	{
	  //use the Brick set and get methods
	  
	  setX( getX() - speed ); 
	  
	  // add the code to keep the paddle from going off the screen to the left.
	  
	}

	public void moveRight()
	{
	  //use the Brick set and get methods	
	  
	  //add code to move to the right
	  
	  // keep the paddle from going off the screen to the right.
	}	
	
	//overidde paint to draw your Paddle
	public void paint( Graphics window )
	{
		window.drawString("Paddle Class ", 50, 150 );

		//Draw the Paddle with graphics methods
		//or use an Image
		
		
		//PICK ONE -  YOU CANNOT DO BOTH!!!!
		
		
		/*
		window.setColor(Color.RED);
		window.fillRect(getX(), getY(), getW(), getH());
		window.setColor(Color.BLACK);
		window.drawRect(getX(), getY(), getW(), getH());
		*/

		//Find an Image for your Paddle.
		/*
		Graphics2D g2 = (Graphics2D) window;
    	Image img1 = Toolkit.getDefaultToolkit().getImage("paddle.png"); //use .gif or .png, you can choose the image
    	g2.drawImage(img1, getX(), getY(), getW(), getH(), this);
    	*/
	}
}