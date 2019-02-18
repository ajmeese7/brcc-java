/*
 * MeeseCircleClass.java
 * Author: Aaron Meese
 * Date: 1/29/19
 * 
 * Calculates the area, diameter, and circumference of
 * a circle with a radius that is input by the user.
 * 
 */

import java.util.Scanner;

public class MeeseCircleClass {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the circle's radius: ");
		
		double radius = keyboard.nextDouble();
		Circle circle = new Circle(radius);
		System.out.println("Area: " + circle.getArea());
		System.out.println("Diameter: " + circle.getDiameter());
		System.out.println("Circumference: " + circle.getCircumference());
		
		keyboard.close();
	}

}
