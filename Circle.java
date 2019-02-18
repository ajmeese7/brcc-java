/*
 * Circle.java
 * Author: Aaron Meese
 * Date: 1/29/19
 * 
 * Creates a circle object with several methods
 * that can be called on it. The methods are extremely
 * self-explanatory, so there was no reason to comment
 * on their return values, parameters, or purpose.
 * 
 */

public class Circle {
	private double radius;
	private final double PI = 3.14159;
	
	public Circle() {
		radius = 0.0;
	}
	
	public Circle(double r) {
		radius = r;
	}
	
	public void setRadius(double r) {
		radius = r;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return PI * radius * radius;
	}
	
	public double getDiameter() {
		return radius * 2;
	}
	
	public double getCircumference() {
		return 2 * PI * radius;
	}
}
