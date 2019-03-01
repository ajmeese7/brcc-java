/*
 * Cylinder.java
 * Author: Aaron Meese
 * Date: 2/28/19
 * 
 * Creates a cylinder with a radius and 
 * length (height). Can return area (SA)
 * and volume.
 * 
 */

public class Cylinder extends Circle {
	private double radius;
	private double length;
	private Circle base;
	
	// There is no need to create a Cylinder without a length and radius
	public Cylinder(double length, double radius) {
		this.length = length;
		this.radius = radius;
		base = new Circle(radius);
	}
	
	public double getArea() {
		double area = (2 * PI * radius * length) + (2 * this.base.getArea());
		area = Math.round(area * 1000.0) / 1000.0;
		return area;
	}
	
	public double getVolume() {
		double volume = this.base.getArea() * length;
		volume = Math.round(volume * 1000.0) / 1000.0;
		return volume;
	}
}
