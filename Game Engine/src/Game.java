import java.awt.*;
import java.awt.event.*;

import javax.swing.event.MouseInputAdapter;

public class Game extends Frame
{
  private class HandleInput extends KeyAdapter
  {
	  
    public void keyPressed(KeyEvent e)
    {
      char key = e.getKeyChar();
      switch(key)
      {
        case 'q':
          System.exit(0);
          break;
      }
    }
  }
  
  private class MouseInput extends MouseInputAdapter
  {
	  public void mousePressed(MouseEvent e)
	  {
		  if (sone.contains(e.getX(),e.getY()))
		  {
			  System.out.println("inside square at" + e.getX() + " " + e.getY());
			updateMouse(e);  
		  }
		  else
		  {
			  pressOut = false;
		  }
	  }
	  
	  public void mouseReleased(MouseEvent e)
	  {
		  if (sone.contains(e.getX(),e.getY()))
		  {
			System.out.println("inside square at" + e.getX() + " " + e.getY());
			updateMouse(e);  
		  }
		  else
		  {
			  pressOut = false;
		  }
	  }
	  
	  public void mouseDragged(MouseEvent e)
	  {
		  if (!pressOut)
		  {
			  updateMouse(e);
		  }
	  }
	  
	  public void mouseMoved (MouseEvent e)
	  {
	  }
	  
	  public void mouseClicked (MouseEvent e)
	  {
		  System.out.println("inside square at" + e.getX() + " " + e.getY());
	  }
	  
	  public void mouseExited(MouseEvent e)
	  {
	  }
	  
	  public void mouseEntered(MouseEvent e)
	  {
	  }  
  }
  
  private static Square sone = null;
  private Graphics2D g2d;
  boolean pressOut = false;
  
  private Game()
  {
    this.setTitle("Game Engine: Squareville Ed");
    this.setLocation(100,100);
    this.setSize(600,400);
    this.setBackground(Color.white);
    addKeyListener(new HandleInput());
    addMouseMotionListener(new MouseInput());
    addMouseListener(new MouseInput());
  }
  
  public static void main(String[] args)
  {
    Game window = new Game();
    sone = new Square(300,200);
    window.setVisible(true);
    window.run();
  }
  
  private void run()
  {
    while(true)
    {
    	//sone.rotation(Math.PI/4);
    	
      repaint();
      try
      {
        Thread.sleep(100);
      } catch (Exception e)
      {
        System.exit(1);
      }
    }
  }
  
  public void updateMouse(MouseEvent e)
  {
	  sone.updateSquare(e.getX(), e.getY());
	  
	  repaint();
  }
    
  public void paint(Graphics g)
  {
	Graphics2D square2D = (Graphics2D) g;
	
	//square2D.translate(250,200);
	
    sone.paint(square2D);
  }
  
}