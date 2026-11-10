import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BreakOut extends JPanel implements Runnable, KeyListener
{
	private boolean[] keys; // this stores booleans for when a key is pressed or not.


	//NOTE - DO ALL of STEP 1 FIRST!
	//PADDLE MUST WORK COMPLETELY
	//step 1
	// define a Paddle
	
	
	
	//NOTE : CCOMPLETE ALL of STEP 2 AFTER the PADDLE works
	//step 2
	// define a Ball



	//NOTE : CCOMPLETE ALL of STEP 3 AFTER the PADDLE and BALL BOTH WORK
	//step 3
	// define an ArrayList of Brick

      

	public BreakOut() // create all instance in here
	{
		setBackground(Color.WHITE);

		//make the keys array big enough to store all keys pressed
		keys = new boolean[3];		

      
		//Step 1
		//initialize the Paddle
		//put the paddle close to the bottom of the screen.


		//Step 2
		//initialize the Ball
		//start the bal in the middle of the screen


		//Step 3
		//make an ArrayList of Bricks

		//Step 3
		//use loops to add Bricks to your ArrayList< Brick >
		// 	each brick will need to have different x & y coordinates, but same width and height
		// 	the x & y coordinates should be based on the width and height you choose


		//DO NOT TOUCH these 3 lines
		addKeyListener( this );   	
		setFocusable( true );		
		new Thread(this).start();	
	}

	// all drawing and game logic goes here
	public void paint( Graphics window )
	{
		// makes the background white
		window.setColor(Color.WHITE); 
		window.fillRect( 0,0, 800, 600); 
			
		// draws a black box around the outside
		window.setColor(Color.BLACK); 
		window.drawRect( 0,0, 800, 600); 

		window.setColor(Color.BLUE); 

		// space is pressed
		if(keys[0]) 
		{
			//what do you do here?		
		}
		// left arrow is pressed
		if(keys[1]) 
		{
			//move the paddle left			
			keys[1] = false;
		}
		// right arrow is pressed
		if(keys[2]) 
		{	
			//move the paddle right         
			keys[2] = false;
		}

		//step 1 - draw a Paddle
		

		//step 2 - draw a Ball
		

		//step 3 -draw the bricks
		
		
		//step 4 - GAME LOGIC
		//add logic to see if the ball hits the paddle
		//add logic to see if the ball hits the bricks
	}	

	// only edit if you would like to add more key functions
	public void keyPressed(KeyEvent e)
	{   
		
		if( e.getKeyCode()  == KeyEvent.VK_SPACE )
		{
			keys[0]=true;
		}
		
		if( e.getKeyCode()  == KeyEvent.VK_LEFT )
		{
			keys[1]=true;
		}
		
		if( e.getKeyCode()  == KeyEvent.VK_RIGHT )
		{
			keys[2]=true;
		}					
	}

	// do not edit anything from this point on!!!
	public void keyTyped(KeyEvent e)
	{
		keyPressed( e );			
	}	
			
	public void keyReleased(KeyEvent e)	{ 	}
	
	public void run()
	{
		try
		{
			while( true )
			{	
			   Thread.sleep( 10 );
			   repaint();
			}
		}
		catch( Exception e )
		{			
		}
	}
}