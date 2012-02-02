import java.awt.*;
import java.awt.event.*;

public class Game extends Frame
{
  private class HandleInput extends KeyAdapter
  {
    public void keyPressed(KeyEvent e)
    {
      char key = e.getKeyChar();
      switch(key)
      {
      	case 'd':
    	  sone.rotateLeft();
    	  break;
      	case 'f':
    	  sone.rotateRight();
    	  break;
        case 'q':
          System.exit(0);
          break;
      }
    }
  }
  
  private static Square sone = null;
  
  private Game()
  {
    this.setTitle("Game Engine: Squareville Ed");
    this.setLocation(100,100);
    this.setSize(600,400);
    this.setBackground(Color.white);
    addKeyListener(new HandleInput());
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
    
  public void paint(Graphics g)
  {
    sone.paint(g);
  }
}