/*
 * MeeseWeatherForecast.java
 * Author: Aaron Meese
 * Date: 2/24/19
 * 
 * Receives user input for creating a weather forecast.
 * It requires the temperature and sky conditions
 * entered to be valid, and outputs the temperature in
 * Celsius and whether or not the temperature and the
 * sky condition are consistent. 
 * 
 */

import java.util.Scanner;

public class MeeseWeatherForecast {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		int skyCondition = 1;
		double temperature; 
		Weather weather;
		
		System.out.println("                  Instructions: ");
		System.out.println("For sky conditions, enter a number 1-4 that corresponds\n" +
						   "to one of the conditions listed below. Enter 5 to stop the \n"
						   + "program or any other number to see the options again.\n");
		
		while (skyCondition != 5) {
			System.out.print("Select an option for sky conditions: ");
			if (keyboard.hasNextInt()) {
				skyCondition = keyboard.nextInt();
				while (skyCondition < 1 || skyCondition > 5) {
					printOptions();
					System.out.println("Please select an option between 1 and 5.");
					skyCondition = keyboard.nextInt();
				}
				
				if (skyCondition == 5) {
					continue;
				}
			} else {
				System.out.println("Please enter a number and try again.");
				continue;
			}
			
			temperature = -200; // Purposefully outside of range for while loop for temperature prompt
			while (temperature < -50 || temperature > 150) {
				// Makes the user only re-enter the temperature and not the entire condition
				System.out.print("Enter a temperature between -50 and +150: ");
				if (keyboard.hasNextDouble()) {
					temperature = keyboard.nextDouble();
					if (temperature > -50 && temperature < 150) {
						weather = new Weather(skyCondition, temperature);
						System.out.println("Temperature in Celsius: " + weather.convertToCelsius());
						System.out.println("The attributes entered are " + (weather.isConsistent() ? "" : "not ") + "consistent.\n");
					} else {
						System.out.println("Please enter a number between -50 and 150 and try again.\n");
					}
				}
			}
		}
		
		keyboard.close();
	}
	
	public static void printOptions() {
		System.out.println("1: Sunny");
		System.out.println("2: Snowy");
		System.out.println("3: Cloudy");
		System.out.println("4: Rainy");
		System.out.println("5: STOP");
	}
}
