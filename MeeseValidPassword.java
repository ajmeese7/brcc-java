/*
 * MeeseValidPassword.java
 * Author: Aaron Meese
 * Date: 2/15/19
 * 
 * Requests a password from the user then asks them
 * to repeat it. The password must fit the specifications,
 * which are that it must be between 5 and 8 characters,
 * contain at least one letter, one number, and one of the 
 * following special characters: $, *, or #.
 * 
 */

import java.util.Scanner;

public class MeeseValidPassword {

	public static void main(String[] args) {
		// Because it did not specify, I am assuming the program is
		// only supposed to run once. If that is not the case, please let me
		// know and I will be happy to rewrite it to fit your specifications.
		Scanner keyboard = new Scanner(System.in);
		String password, tempPassword;
		
		System.out.print("Enter password: ");
		password = keyboard.next();
		
		if (validPassword(password)) {
			// Saves the old password for comparison purposes
			tempPassword = password;
			System.out.print("Enter password again: ");
			password = keyboard.next();
			
			if (password.equals(tempPassword)) {
				System.out.println("You are now registered as a new user.");
			} else {
				System.out.println("Sorry, please try again");
			}
		} else {
			System.out.println("Sorry, please try again");
		}
		
		keyboard.close();
	}
	
	public static boolean validPassword(String password) {
		if (password.length() >= 5 && password.length() <= 8) {
			boolean letter = false, number = false, special = false, stop = false;
			
			for (int i = 0; i < password.length(); i++) {
				if (Character.isLetter(password.charAt(i))) {
					letter = true;
				} else if (Character.isDigit(password.charAt(i))) {
					number = true;
				} else if (password.charAt(i) == '*' || password.charAt(i) == '$' || password.charAt(i) == '#') {
					special = true;
				} else {
					stop = true;
					break;
				}
			}
			
			if (!stop && letter && number && special) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
