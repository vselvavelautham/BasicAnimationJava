import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BouncingBall extends JFrame
{
	private final int x = 109; 
	private final int WIDTH = 40;
	private final int HEIGHT = 40;
	private final int TIME_DELAY = 30; 
	private final int MOVE = 20; 
	private final int MINIMUM_Y = 50; 
	private final int MAXIMUM_Y = 400; 
	private int y = 400; 
	private boolean goingUp = true; 
	private Timer timer; 
	private JLabel banner = new JLabel("Here are a few bouncing balls"); 
	
	public BouncingBall()
	{
		setTitle("BouncingBalls"); 
		
		setSize(500, 600); 
		
		setLayout(new BorderLayout()); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		setVisible(true); 
		
		add(banner, BorderLayout.NORTH); 
		
		timer = new Timer(TIME_DELAY, new TimerListener()); 
		timer.start();
	}
	
	public void paint (Graphics g)
	{
		super.paint(g);
		
		g.setColor(Color.MAGENTA);
		
		g.fillOval(x, y, WIDTH, HEIGHT);
		
		g.setColor(Color.CYAN);
		
		g.fillOval(250, y, 80, 80);
		
	}
	
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (goingUp)
			{
				if (y > MINIMUM_Y)
					y -= MOVE; 
				else 
					goingUp = false;
			}
			else 
			{
				if (y < MAXIMUM_Y)
					y += MOVE; 
				else 
					goingUp = true; 
			}
			
			repaint(); 
		}
	}
	
	public static void main(String[] args)
	{
		new BouncingBall(); 
	}
}
