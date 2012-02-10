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
	
	public abstract void paint(Graphics2D g);
	
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
	
	public void setPosX(double px)
	{
		posX = px;
	}
	
	public void setPosY(double py)
	{
		posY = py;
	}
	
}
