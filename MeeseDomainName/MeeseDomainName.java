/*
 * MeeseDomainName.java
 * Author: Aaron Meese
 * Date: 2/24/19
 * 
 * Receives user input for a domain name and 
 * outputs the prefix, extension, and the 
 * domain name.
 * 
 */

import java.util.Scanner;

public class MeeseDomainName {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a domain name: ");
		String name = keyboard.next();
		
		DomainName domain = new DomainName(name);
		System.out.println("Prefix: " + ((domain.hasPrefix() ? "Yes" : "No")));
		System.out.println("Extension: " + domain.extension());
		System.out.println("Domain name: " + domain.getName());
		
		keyboard.close();
	}

}
