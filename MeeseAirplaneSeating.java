/*
 * MeeseAirplaneSeating.java
 * Author: Aaron Meese
 * Date: 2/16/19
 * 
 * Receives user input for reserving a seat on an
 * airplane. It first displays the seats available on
 * the plane, then prompts the user for their desired 
 * class, row, and seat, after displaying the instructions.
 * 
 */

import java.util.Scanner;

public class MeeseAirplaneSeating {
	public static char[][] plane = new char[13][6];
	
	public static void main(String[] args) {
		populatePlane();
		displaySeats();
		
		Scanner keyboard = new Scanner(System.in);
		// Initializing it to appease the Eclipse gods
		int row = 1;
		char seat = 0;
		String section = "";
		
		System.out.println("            Instructions: ");
		System.out.println("Your row must be within the class you select.");
		System.out.println("Your seat must be between A and F (inclusive).");
		System.out.println("To stop inputting seats, type 'stop' as your section.");
		
		while (!section.equals("stop")) {
			// NOTE: Not technically a menu-driven program, so I might get points off
			System.out.print("Section: First Class, Business, or Economy? ");
			section = keyboard.next().toLowerCase();
			if (!section.equals("stop") && !section.contains("first") 
				&& !section.equals("business") && !section.equals("economy")) {
				
				System.out.println("That was not a valid class. Please try again.");
				continue;
		    } else if (!section.equals("stop")) { // The program is not stopped
		    	System.out.print("Pick a row between " + sectionRows(section) + ": ");
		    	if (!keyboard.hasNextInt()) {
					while (!keyboard.hasNextInt()) {
						System.out.println("You must enter a row number within your class. Please try again.");
						System.out.print("Pick a row between " + sectionRows(section) + ": ");
				        keyboard.next();
				    }
				}
		    	
		    	row = keyboard.nextInt();
		    	if (section.contains("first")) {
		    		if (row < 0 || row > 2) {
		    			System.out.println("You must enter a row number within your class. Please try again.");
		    			continue;
		    		}
		    	} else if (section.equals("business")) {
		    		if (row < 3 || row > 7) {
		    			System.out.println("You must enter a row number within your class. Please try again.");
		    			continue;
		    		}
		    	} else if (section.equals("economy")) {
		    		if (row < 8 || row > 13) {
		    			System.out.println("You must enter a row number within your class. Please try again.");
		    			continue;
		    		}
		    	}
		    	
		    	System.out.print("Pick a seat between A and F: ");
				if (keyboard.hasNext()) {
					seat = keyboard.next().charAt(0);
					if (!Character.isLetter(seat)) {
						System.out.println("Please try again. The seat needs to be a letter between A and F.");
						continue;
				    }
				} else {
					// Should never be called, but just to be safe...
					System.out.println("Please try again. The seat needs to be a letter between A and F.");
					continue;
				}
				
				seat = Character.toLowerCase(seat);
				if (seat < 'a' || seat > 'f') {
					System.out.println("Please try again. The seat needs to be a letter between A and F.");
					continue;
				}
				
				int col = seat - 'a' + 1;
				
				if (plane[row - 1][col - 1] != 'X') {
					plane[row - 1][col - 1] = 'X';
					displaySeats();
				} else {
					// Makes sense to have, because in a real-world situation other users
					// will be booking seats, but in this assignment it isn't necessary
					// because if the same user rebooks a seat it will only be booked once.
					System.out.println("Please try again. That seat is already booked.");
				}
				
		    } else {
		    	System.out.println("Thank you for booking with us today. Have a great flight!");
		    }
		}
		
		keyboard.close();
	}
	
	public static String sectionRows(String section) {
		if (section.contains("first")) {
			return "1 and 2";
		} else if (section.equals("business")) {
			return "3 and 7";
		} else {
			return "8 and 13";
		}
	}
	
	// Only needs to be called once; fills the plane[][]
	// with asterisks to indicate available seats.
	public static void populatePlane() {
		for (int row = 0; row < plane.length; row++) {	
			for (int col = 0; col < plane[row].length; col++) {
				plane[row][col] = '*';
			}
		}
	}
	
	// Shows which seats are available and which are occupied.
	public static void displaySeats() {
		System.out.println("        A  B  C    D  E  F");
		
		for (int row = 1; row <= plane.length; row++) {
			int digits = Integer.toString(row).length();
			if (digits == 1) {
				System.out.print("Row " + row + "   ");
			} else {
				System.out.print("Row " + row + "  ");
			}
			
			for (int col = 1; col <= plane[row - 1].length; col++) {
				if (col % 3 == 0) {
					System.out.print(plane[row - 1][col - 1] + "    ");
				} else {
					System.out.print(plane[row - 1][col - 1] + "  ");
				}
			}
			
			System.out.println();
		}
	}
}
