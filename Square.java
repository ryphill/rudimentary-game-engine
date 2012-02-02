import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
public class Square extends Actor {

	private int Ax, Ay, Bx, By, Cx, Cy, Dx, Dy;
	private static final double ANGLE_CHANGE = 0.1;
	private final int SQUARE_LENGTH = 50;
	private final Color SQUARE_COLOR = Color.black;
	private double angle = (Math.PI)/2;
	//private double baseX, baseY;
	
	public Square(double px, double py)
	{
		super(px,py);
		//baseX = px;
		//baseY = px;
	}
	
	public void rotateLeft()
	{
		angle += ANGLE_CHANGE;
	}
	
	public void rotateRight()
	{
		angle -= ANGLE_CHANGE;
	}
	
	public void paint(Graphics g)
	{
		Polygon p = new Polygon();
		
		if (angle <= Math.PI/2)
		{
			Ax = (int) (getPosX() - SQUARE_LENGTH/2);
			Ay = (int) getPosY();
			p.addPoint(Ax, Ay);
			
			Bx = (int) (getPosX() + SQUARE_LENGTH/2);
			By = (int) (getPosY() + Math.cos(angle)*SQUARE_LENGTH);
			p.addPoint(Bx, By);
			
			Cx = (int) (Bx - Math.cos(angle)*SQUARE_LENGTH);
			Cy = (int) (By + Math.sin(angle)*SQUARE_LENGTH);
			p.addPoint(Cx, Cy);
			
			Dx = (int) (Cx - Math.cos(Math.PI/2 - angle)*SQUARE_LENGTH);
			Dy = (int) (Cy - Math.sin(Math.PI/2 - angle)*SQUARE_LENGTH);
			p.addPoint(Dx, Dy);
		} else {
			Ax = (int) (getPosX() + SQUARE_LENGTH/2);
			Ay = (int) getPosY();
			p.addPoint(Ax, Ay);
			
			Bx = (int) (getPosX() - SQUARE_LENGTH/2);
			By = (int) (getPosY() - Math.cos(angle)*SQUARE_LENGTH);
			p.addPoint(Bx, By);
			
			Cx = (int) (Bx - Math.cos(angle)*SQUARE_LENGTH);
			Cy = (int) (By - Math.sin(angle)*SQUARE_LENGTH);
			p.addPoint(Cx, Cy);
			
			Dx = (int) (Cx + Math.sin(angle - Math.PI/2)*SQUARE_LENGTH);
			Dy = (int) (Cy - Math.cos(angle - Math.PI/2)*SQUARE_LENGTH);
			p.addPoint(Dx, Dy);
		}
		
		g.setColor(SQUARE_COLOR);
		g.fillPolygon(p);
		
	}
}
