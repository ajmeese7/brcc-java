/*
 * MeeseGasTank.java
 * Author: Aaron Meese
 * Date: 1/23/19
 * 
 * Calculates the average distance a car can travel on
 * one tank of gas in town and on the highway.
 * 
 */

import javax.swing.JOptionPane; 

public class MeeseGasTank {

	public static void main(String[] args) {
		
		// Define initial variables
		int numGallons = 20;
		double townMPG = 21.5, highwayMPG = 26.8;
		
		// Perform specified calculations
		double townDistance = numGallons * townMPG;
		double highwayDistance = numGallons * highwayMPG;
		
		// Display the calculated information
		JOptionPane.showMessageDialog(null, "City: " + townDistance + "\nHighway: " + highwayDistance);
	}

}
