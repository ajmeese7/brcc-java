/*
 * MeeseRainfall.java
 * Author: Aaron Meese
 * Date: 1/23/19
 * 
 * Calculates the average rainfall for NUM_ENTRIES months.
 * The program asks the user to enter the name of each month, 
 * such as June or July, and the amount of rain (in inches) that fell 
 * each month. The program displays a message similar to the following: 
 * "The average rainfall for June, July, and August is 6.72 inches."
 * 
 */

import java.util.Scanner;

public class MeeseRainfall {
	/** The number of times that the for loop will iterate **/
	public static int NUM_ENTRIES = 3;
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		String finalString = "The average rainfall for ";
		double totalRain = 0;
		
		for (int i = 0; i < NUM_ENTRIES; i++) {
			System.out.print("Enter the name of the month: ");
			String month = keyboard.next(); // I prefer it when the input is on the same line as the prompt
			
			if (i < NUM_ENTRIES - 1) {
				finalString += month + ", ";
			} else {
				finalString += "and " + month;
			}
			
			System.out.print("Enter the amount of rain (in inches): ");
			double rainfall = keyboard.nextDouble();
			
			totalRain += rainfall;
		}
		
		double average = totalRain / NUM_ENTRIES;
		finalString += " is " + average + " inches.";
		System.out.println(finalString);
		
		keyboard.close();
	}

}
