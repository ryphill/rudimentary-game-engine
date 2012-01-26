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
        case 'q':
          System.exit(0);
          break;
      }
    }
  }
  
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
        Thread.sleep(10000);
      } catch (Exception e)
      {
        System.exit(1);
      }
    }
  }
    
  public void paint(Graphics g)
  {
    g.drawRect(300,200,90,90);
    g.setColor(Color.red);
    g.fillRect(301,201,90,90);
  }
}