import java.awt.Point;

public class Quadrilateral extends Shape{

	protected Quadrilateral(Point[] aPoints){
		super("Quadrilateral");
		
		Point[] arr = new Point[4];
		arr[0] = aPoints[0];
		arr[1] = aPoints[1];
		arr[2] = aPoints[2];
		arr[3] = aPoints[3];
				
		super.setPoints(arr);
	}
	
	@Override
	public double getPerimeter(){
		Point[] points = getPoints();
		
		double sideOne = getDistance(getPoints()[0], getPoints()[1]);
		double sideTwo = getDistance(getPoints()[1], getPoints()[2]);
		double sideThree = getDistance(getPoints()[2], getPoints()[3]);
		double sideFour = getDistance(getPoints()[3], getPoints()[0]);
		
		return sideOne + sideTwo + sideThree + sideFour;
	}
	
	@Override
	public double getArea(){
		Point[] points = getPoints();
		
		double Ax = points[0].getX();
		double Ay = points[0].getY();
		double Bx = points[1].getX();
		double By = points[1].getY();
		double Cx = points[2].getX();
		double Cy = points[2].getY();
		double Dx = points[3].getX();
		double Dy = points[3].getY();
		
		double area = Math.abs((((Ax * By) - (Ay * Bx)) + ((Bx * Cy) - (By * Cx)) + 
				((Cx * Dy) - (Cy * Dx)) + ((Dx * Ay) - (Dy * Ax))) / 2);
		
		return area;
	}
}
