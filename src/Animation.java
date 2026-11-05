import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.MouseInfo;

public class Animation extends JPanel implements Runnable
{
	int x = 0;
	int y = 0;
	public Animation()
	{
		setBackground(Color.WHITE);

		new Thread(this).start();
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.BLUE);

		window.fillRect(0,0,1000,800);

		window.setColor(Color.BLACK);

		x = x + 10;
		y = y + 10;

		if( x > 1000)
			x = 0;
		if( y > 800)
			y = 0;

		window.fillRect(x, y, 20, 20);
		
	}
	
	public void run()
	{

		try
		{
			while( true )
			{	
			   Thread.sleep(50);
			   repaint();
			}
		}
		catch( Exception e )
		{
			
		}

	}
}