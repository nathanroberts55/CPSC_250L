import java.awt.Point;

public abstract class Shape {
	
private String name;
private Point[] points;

protected Shape(String aName){
	name = aName;
}

public final String getName(){
	return name;
}

protected final void setPoints(Point[] thePoints){
	points = thePoints;
}

public final Point[] getPoints(){
	return points;
}

public static double getDistance(Point p1, Point p2){
	return Math.sqrt((Math.pow((p2.getX() - p1.getX()), 2)) + (Math.pow((p2.getY() - p1.getY()), 2)));
}

public abstract double getPerimeter();

public abstract double getArea();


}
