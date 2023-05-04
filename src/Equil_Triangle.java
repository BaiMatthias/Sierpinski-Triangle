import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Random;

public class Equil_Triangle {

	private Point p1;
	private Point p2;
	private Point p3;
	public Point getP1() {
		return p1;
	}
	public void setP1(int x, int y){
		this.p1 = new Point(x,y);
	}
	public Point getP2() {
		return p2;
	}
	public void setP2(int x, int y){
		this.p2 = new Point(x,y);
	}
	public Point getP3() {
		return p3;
	}
	public void setP3(int x, int y){
		this.p3 = new Point(x,y);
	}
	
	
	public Equil_Triangle(Frame frame){
		p1 = new Point(frame.getWidth()/3, frame.getHeight()/3*2);
		p2 = new Point(frame.getWidth()/3*2, frame.getHeight()/3*2);
		double pheight = (Math.sqrt(3)/2) * (p2.getX() - p1.getX());
		p3 = new Point((int)((p1.getX()+p2.getX())/2), (int)((p1.getY()+p2.getY())/2 - pheight));
		//proof(p1, p2, p3);
		
	}
	public int[] getXPoints(){
		return new int[]{(int) this.p1.getX(),(int) this.p2.getX(), (int) this.p3.getX()};
	}
	public int[] getYPoints(){
		return new int[]{(int) this.p1.getY(), (int) this.p2.getY(), (int) this.p3.getY()};
	}
	private void proof(Point p1, Point p2, Point p3){
		double differenzX =  (p2.getX() - p1.getX());
		double differenzY =  (p2.getY() - p1.getY());
		double abstand = Math.pow(differenzX, 2) + Math.pow(differenzY, 2);
		System.out.println(Math.sqrt(abstand));
		differenzX = p1.getX() - p3.getX();
		differenzY = p1.getY() - p3.getY();
		abstand = Math.pow(differenzX, 2) + Math.pow(differenzY, 2);
		System.out.println(Math.sqrt(abstand));
		differenzX = p3.getX() - p2.getX();
		differenzY = p3.getY() - p2.getY();
		abstand = Math.pow(differenzX, 2) + Math.pow(differenzY, 2);
		System.out.println(Math.sqrt(abstand));
	}
	
	
	public void sierpinski(Point p1, Point p2, Point p3, int tiefe, Graphics gra){
		Random rnd = new Random();
		if(tiefe == 0){
			return;
		}
		else{
			tiefe--;
			int r = rnd.nextInt(256);
			int g = rnd.nextInt(256);
			int b = rnd.nextInt(256);
			Color c = new Color(r,g,b);
			gra.setColor(c);
			gra.fillPolygon(new int[]{(int) p1.getX(), (int) p2.getX(), (int) p3.getX()}, new int[]{(int) p1.getY(), (int) p2.getY(), (int) p3.getY()},3);
			sierpinski(p1, calculateMid(p1, p2), calculateMid(p1, p3), tiefe, gra);
			sierpinski(calculateMid(p1, p2), p2, calculateMid(p2, p3), tiefe, gra);
			sierpinski(calculateMid(p1, p3), calculateMid(p2, p3), p3, tiefe, gra);
			
			}
	}
	
	
	private Point calculateMid(Point p1, Point p2){
		return new Point((int)(p1.getX()+p2.getX())/2, (int)(p1.getY()+p2.getY())/2);
	}
}
