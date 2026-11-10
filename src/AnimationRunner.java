import javax.swing.JFrame;

public class AnimationRunner extends JFrame
{
	private static final int WIDTH = 5000;
	private static final int HEIGHT = 1500;

	public AnimationRunner()
	{
		super("TITLE HERE");

		setSize(WIDTH,HEIGHT);
		
		getContentPane().add( new Animation() ); 


		setVisible(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		AnimationRunner run = new AnimationRunner();
	}
}