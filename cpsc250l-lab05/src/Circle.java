import java.awt.Point;

public class Circle extends Shape{
	
	private double Radius;
	
	protected Circle(Point aCenter, double radius){
		super("Circle");
		
		Point[] arr = new Point[1] ;
		arr[0] = aCenter;
		
		super.setPoints(arr);
		
		
		if(radius < 0.0){
			Radius  = 0.0;
		}
		else{
			Radius = radius;
		}
	}
	
	
	
	public double getRadius(){
		return Radius;
	}
	
	@Override
	public double getPerimeter(){
		return 2 * Math.PI * getRadius();
	}
	
	@Override
	public double getArea(){
		return Math.PI * (Math.pow(getRadius(), 2));
	}
}
