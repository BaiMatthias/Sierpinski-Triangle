import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;

public class Canvas extends Frame{
	private static final long serialVersionUID = 1L;

	private Equil_Triangle triangle;
	
	
	public Canvas(){
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screen.getWidth();
		double height = screen.getHeight();
		this.setSize((int)width, (int)height-40);
		this.setVisible(true);
		triangle = new Equil_Triangle(this);
		
	}
	
	@Override
	public void paint(Graphics g){
		triangle.setP1(this.getWidth()/3, this.getHeight()/3*2);
		triangle.setP2(this.getWidth()/3*2, this.getHeight()/3*2);
		double pheight = (Math.sqrt(3)/2) * (triangle.getP2().getX() - triangle.getP1().getX());
		triangle.setP3((int)((triangle.getP1().getX()+triangle.getP2().getX())/2),
				(int)((triangle.getP1().getY()+triangle.getP2().getY())/2 - pheight));
		triangle.sierpinski(triangle.getP1(), triangle.getP2(), triangle.getP3(), 5, g);
	}

	
}
