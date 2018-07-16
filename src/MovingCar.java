import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class MovingCar extends JFrame
{ 
	private final int y = 200; 
	private final int TIME_DELAY = 30; 
	private final int MOVE = 20; 
	private final int MINIMUM_X = 50; 
	private final int MAXIMUM_X = 600; 
	private int x = 150; 
	private boolean goingRight = true; 
	private Timer timer; 
	private JLabel messageLabel = 
			new JLabel("Press 'S' to stop & Press 'M' to move again"); 
	
	public MovingCar()
	{
		setTitle("MovingCar"); 
		
		setSize(800, 500); 
		
		setLayout(new BorderLayout());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		setVisible(true); 
		
		add(messageLabel, BorderLayout.NORTH); 
		
		timer = new Timer(TIME_DELAY, new TimerListener()); 
		this.addKeyListener(new MyKeyListener()); 
		timer.start();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor(Color.ORANGE);
		
		g.fillRect(x, y, 125, 75);
		
		g.setColor(Color.BLUE);
		
		g.fillOval((x + 10), (y + 70), 20, 20); 
		
		g.fillOval((x + 95), (y + 70), 20, 20);
		
		
	}
	
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (goingRight)
			{
				if (x > MINIMUM_X)
					x -= MOVE; 
				else 
					goingRight= false; 
			}
			else 
			{
				if (x < MAXIMUM_X)
					x += MOVE; 
				else 
					goingRight = true;
			}
			
			repaint(); 
		}
	}
	
	private class MyKeyListener implements KeyListener
	{
		public void keyTyped(KeyEvent e)
		{
			char c = e.getKeyChar(); 
			
			if (c == 's')
				timer.stop();
			else if (c == 'm')
				timer.start();
			
		}


		public void keyPressed(KeyEvent e) 
		{
			char c = e.getKeyChar(); 
			
			if (c == 's')
				timer.stop();
			else if (c == 'm')
				timer.start();
			
		}

		
		public void keyReleased(KeyEvent e) 
		{
char c = e.getKeyChar(); 
			
			if (c == 's')
				timer.stop();
			else if (c == 'm')
				timer.start();
			
		}
	}
	public static void main(String[] args)
	{
		new MovingCar(); 
	}
}