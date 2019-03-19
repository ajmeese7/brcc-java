/*
 * MeeseCheckBoxes.java
 * Author: Aaron Meese
 * Date: 3/19/19
 * 
 * This is a GUI application that displays a 
 * circle with a color that depends on which
 * checkboxes the user selects. Possible combinations
 * lead to 5 color outcomes for the circle: red,
 * yellow, green, purple, and orange.
 * 
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MeeseCheckBoxes extends Application {
	CheckBox red = new CheckBox("RED");
	CheckBox yellow = new CheckBox("YELLOW");
	CheckBox green = new CheckBox("GREEN");
	Circle circle = new Circle(100, Color.BLACK);

	public static void main(String[] args) {
		// Launch the application.
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		circle.setStroke(Color.BLACK);
		
		red.setOnAction(event -> {
			changeCircleColor();
		});
		yellow.setOnAction(event -> {
			changeCircleColor();
		});
		green.setOnAction(event -> {
			changeCircleColor();
		});
		
		VBox vbox = new VBox(10, circle, red, yellow, green);
		vbox.setPadding(new Insets(30));
		
		// Add vertical group to the scene and add the scene to the stage
		primaryStage.setTitle("Change Circle Color");
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void changeCircleColor() {
		boolean r = red.isSelected();
		boolean y = yellow.isSelected();
		boolean g = green.isSelected();
		
		if (r && !y && !g) {
			circle.setFill(Color.RED);
		} else if (y && !r && !g) {
			circle.setFill(Color.YELLOW);
		} else if (g && !r && !y) {
			circle.setFill(Color.GREEN);
		} else if (r && y && !g) {
			circle.setFill(Color.PURPLE);
		} else if (y && g && !r) {
			circle.setFill(Color.ORANGE);
		} else {
			circle.setFill(Color.BLACK);
		}
	}
}
