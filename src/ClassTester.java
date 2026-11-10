import java.awt.*;
import javax.swing.*;

public class ClassTester extends JPanel
{
    //instance variables
    
    //COMPLETE all STEP 1s FIRST
    
    //THEN MOVE TO all STEP 2s

    //step 1 - define a Brick


    //step 2 - define a Paddle


    //step 3 - define a Ball


    public ClassTester()
    {
        // create all instance variables here
        setBackground(Color.WHITE);


        //step 1 - initialize - make a new Brick


        //step 2 - initialize - make a new Paddle


        //step 3 - initialize - make a new Ball
        

        //DO NOT DELETE
        setFocusable( true );
    }

	// all other paint methods and game logic goes in here.
    public void paint( Graphics window )
    {
    	// makes the background white
        window.setColor(Color.WHITE); window.fillRect( 0,0, 800, 600); 
        	
        // draws a black box around the outside
        window.setColor(Color.BLACK); window.drawRect( 0,0, 800, 600); 

		// to change fonts, color, etc: go to the Graphics Intro Folder
        window.setColor(Color.BLUE); 
        	

        window.drawString("Class Tester - test all classes here FIRST", 50, 30 );
        

        //step 1 - draw a Brick - call Brick's paint


        //step 2 - draw a Paddle - call Paddle's paint


        //step 3 - draw a Ball - call Ball's paint
        

		repaint();   //refresh the window
    }
}