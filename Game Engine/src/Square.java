//import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

public class Square extends Actor {

	private double radians;
	private AffineTransform transform;
	//private int height = 100;
	//private int width = 100;
	private Image square = null;
	private ImageIcon squareImage = new ImageIcon("./src/square.png");
	//private double baseX, baseY;
	
	public Square(double px, double py)
	{
		super(px,py);
		init();
	}
	
	public void init()
	{
		square = squareImage.getImage();
	}
	
	public void rotation(Double rad)
	{
		radians = rad;
	}
	
	public boolean contains(double px, double py)
	{
		if (((px > getPosX()) && (px <= getPosX() + square.getWidth(null)) && ((py > getPosY()) && (py < getPosY() + square.getHeight(null)))))
			return true;
		return false;
	}
	
	public void updateSquare(double px, double py)
	{
		setPosX(px);
		setPosY(py);
	}
	
	public void paint(Graphics2D g)
	{
		//g.rotate(radians,getPosX(),getPosY());
		//transform = g.getTransform();
		//g.setTransform(transform);
		g.drawImage(square,(int) getPosX(),(int) getPosY(),null);
		//square2D.drawImage(square,300,200,null);
	}
}
