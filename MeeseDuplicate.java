/*
 * MeeseDuplicate.java
 * Author: Aaron Meese
 * Date: 2/28/19
 * 
 * Creates an array of size N, specified by
 * the user, and outputs the array filled with
 * user input (#s between 1 and N) and any
 * duplicates along with the number of times
 * that they appear.
 * 
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MeeseDuplicate {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int length = 0;
		while (length < 1 || length > 12) {
			// Prompt for how long the array should be
			System.out.print("Enter a length between 1 and 12: ");
			
			if (scanner.hasNextInt()) {
				length = scanner.nextInt();
				if (length < 1 || length > 12) {
					System.out.println("Please make sure the number is between 1 and 12.\n");
				}
			} else {
				System.out.println("Please try again.\n");
				scanner.next(); // Skips past the invalid number
			}
		}
		
		Integer[] array = new Integer[length];
		int value = 0;
		
		// Gets all the values for the array
		for (int i = 0; i < length; i++) {
			// Ensures there is a legititimate value placed into the array
			while (value < 1 || value > length) {
				System.out.print("Enter a value between 1 and " + length + ": ");
				
				if (scanner.hasNextInt()) {
					value = scanner.nextInt();
					if (value < 1 || value > length) {
						System.out.println("Please make sure the number is between 1 and " + length + ".\n");
					}
				} else {
					System.out.println("Please try again.\n");
					scanner.next(); // Skips past the invalid number
				}
			}
			
			array[i] = value;
			value = 0;
		}
		
		System.out.println("Array: " + Arrays.toString(array));
		List<Integer> values = Arrays.asList(array);
		
		// Utilizes the pre-written frequency function of Collections
		for (int i = 1; i <= length; i++) {
			int freq = Collections.frequency(values, i);
			if (freq > 1) {
				System.out.println("Duplicate: " + i + "; count: " + freq);
			}
		}
		
		scanner.close();
	}
}
