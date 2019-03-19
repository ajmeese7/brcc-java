/*
 * MeeseSalesTax.java
 * Author: Aaron Meese
 * Date: 3/15/19
 * 
 * This is a GUI application that accepts an amount
 * of sales from the user (in $) and returns either
 * the county tax, sales tax, or total sales tax for
 * that amount, based on the user's button selection.
 * Input validation prevents the user from submitting
 * anything other than a double.
 * 
 */

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MeeseSalesTax extends Application {
	private TextField sales;
	private Label resultLabel;
	final double COUNTY_TAX_RATE = 0.065;
	final double STATE_TAX_RATE = 0.08;
	
	public static void main(String[] args) {
		// Launch the application.
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Monthly Sales Tax");
		
		// Create label and text field and add them to horizontal group
		Label instructions = new Label("Enter the total sales for the month:");
		sales = new TextField("0");
		HBox salesInfo = new HBox(25, instructions, sales);
		salesInfo.setAlignment(Pos.CENTER);
		
		resultLabel = new Label();
		
		// Create buttons and add them to horizontal group
		Button countyTax = new Button("Calculate County Tax");
		Button salesTax = new Button("Calculate Sales Tax");
		Button totalTax = new Button("Calculate Total Sales Tax");
		HBox buttons = new HBox(10, countyTax, salesTax, totalTax);
		
		// Formats the tax to two decimal places
		DecimalFormat df = new DecimalFormat("#0.00");
		
		// Create event handlers
		countyTax.setOnAction(event -> {
			try {
				double totalSales = Double.parseDouble(0 + sales.getText());
				double tax = totalSales * COUNTY_TAX_RATE;
				
				resultLabel.setText("County tax: $" + df.format(tax));
			} catch (NumberFormatException e) {
				sales.setText("0");
				resultLabel.setText("Please enter a positive number.");
			}
		});
		salesTax.setOnAction(event -> {
			try {
				double totalSales = Double.parseDouble(0 + sales.getText());
				double tax = totalSales * STATE_TAX_RATE;
				
				resultLabel.setText("Sales tax: $" + df.format(tax));
			} catch (NumberFormatException e) {
				sales.setText("0");
				resultLabel.setText("Please enter a number.");
			}
		});
		totalTax.setOnAction(event -> {
			try {
				double totalSales = Double.parseDouble(0 + sales.getText());
				double tax = (totalSales * COUNTY_TAX_RATE) + (totalSales * STATE_TAX_RATE);
				
				resultLabel.setText("Total sales tax: $" + df.format(tax));
			} catch (NumberFormatException e) {
				sales.setText("0");
				resultLabel.setText("Please enter a number.");
			}
		});
		
		// Add both horizontal groups and the result label (between them) to a vertical group
		VBox vbox = new VBox(25, salesInfo, resultLabel, buttons);
		vbox.setAlignment(Pos.CENTER);
		
		// Add vertical group to the scene and add the scene to the stage
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
