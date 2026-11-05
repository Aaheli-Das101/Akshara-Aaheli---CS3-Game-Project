import javax.swing.JFrame;

public class AnimationRunner extends JFrame
{
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 800;

	public AnimationRunner()
	{
		super("Animation Example!!");

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