/**
 * 
 */
import java.awt.*;
/**
 * @author rphilli1
 *
 */
public abstract class Actor {
	
	private double posX, posY;
	
	public abstract void paint(Graphics g);
	
	public abstract void rotateLeft();
	
	public abstract void rotateRight();
	
	public Actor(double px, double py)
	{
		posX = px;
		posY = py;
	}

	public double getPosX()
	{
		return posX;
	}
	
	public double getPosY()
	{
		return posY;
	}
	
}
