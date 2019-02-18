/*
 * MeeseFileConverter.java
 * Author: Aaron Meese
 * Date: 1/30/19
 * 
 * Converts the text of one file to lower case
 * and outputs it to another file.
 * 
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MeeseFileConverter {

	public static void main(String[] args) throws IOException {
		
		Scanner keyboard = new Scanner(System.in);
		
		// NOTE: It would be easier to just add the `.txt` extension when creating inputFile,
		// but the instructions are not clear on if that is allowed.
		System.out.print("Enter the name of your input file in the format filename.txt: ");
		
		// NOTE: The path for the file search starts in the Project folder, not the src
		Scanner inputFile = new Scanner(new File(keyboard.next()));
		
		// NOTE: The output text file is not automatically imported to Eclipse, at least on
		// my machine. To view it, open the project in system explorer from the options menu.
		System.out.print("Enter the name of your output file in the format filename.txt: ");
		PrintWriter outputFile = new PrintWriter(keyboard.next());
		
		while (inputFile.hasNext()) {
			// Converts the line to lower case for the output file
			outputFile.print(inputFile.nextLine().toLowerCase() + "\n");
		}
		
		outputFile.close();
		inputFile.close();
		keyboard.close();
	}

}
