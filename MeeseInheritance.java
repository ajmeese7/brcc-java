/*
 * MeeseInheritance.java
 * Author: Aaron Meese
 * Date: 2/28/19
 * 
 * Continually prompts the user for input for
 * the length and radius of cylinders, then 
 * displays the appropriate area and volume 
 * for the specified dimensions.
 * 
 */

import java.util.Scanner;

public class MeeseInheritance {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double length = 0, radius = 0;
		char cont = 'y';
		
		while (Character.toLowerCase(cont) == 'y') {
			// Gets valid length
			while (length <= 0) {
				System.out.print("Enter a length: ");
				
				if (scanner.hasNextDouble()) {
					length = scanner.nextDouble();
					if (length <= 0) {
						System.out.println("Please make sure the number is positive.\n");
					}
				} else {
					System.out.println("Please try again.\n");
					scanner.next(); // Skips past the invalid number
				}
			}
			
			// Gets valid radius
			while (radius <= 0) {
				System.out.print("Enter a radius: ");
				
				if (scanner.hasNextDouble()) {
					radius = scanner.nextDouble();
					if (radius <= 0) {
						System.out.println("Please make sure the number is positive.\n");
					}
				} else {
					System.out.println("Please try again.\n");
					scanner.next(); // Skips past the invalid number
				}
			}
			
			Cylinder cylinder = new Cylinder(length, radius);
			System.out.println("Area: " + cylinder.getArea());
			System.out.println("Volume: " + cylinder.getVolume());
			
			// Couldn't think of a better condition, so just breaks when satisfied.
			while (true) {
				System.out.print("Do you want to continue the program? (Y/N) ");
				
				if (scanner.hasNext()) {
					cont = scanner.next().charAt(0);
					if (cont != 'y' && cont != 'n') {
						System.out.println("Please enter either Y or N.\n");
					} else {
						break;
					}
				} else {
					// Probably isn't needed...
					System.out.println("Please try again.\n");
					scanner.next(); // Skips past the invalid character
				}
			}
			
			length = 0;
			radius = 0;
		}
		
		scanner.close();
	}

}
