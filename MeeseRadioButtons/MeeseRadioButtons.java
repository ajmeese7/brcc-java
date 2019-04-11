/*
 * MeeseRadioButtons.java
 * Author: Aaron Meese
 * Date: 3/19/19
 * 
 * This is a GUI application that displays an
 * image based on which radio button the user
 * selects.
 * 
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MeeseRadioButtons extends Application {

	public static void main(String[] args) {
		// Launch the application.
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Declare images
		Image sunset = new Image("file:src/sunset.jpg");
		Image desert = new Image("file:src/desert.jpg");
		Image other = new Image("file:src/squid.jpg");
		ImageView imageView = new ImageView(sunset);
		
		// Resize the ImageView and preserve the aspect ratio
		imageView.setFitWidth(500);
		imageView.setPreserveRatio(true);
		
		// Put the ImageView in an HBox and center it
		HBox imageHBox = new HBox(imageView);
		imageHBox.setAlignment(Pos.CENTER);
		
		// Create the RadioButtons & add them to VBox
		RadioButton sunsetRadio = new RadioButton("SUNSET");
		RadioButton desertRadio = new RadioButton("DESERT");
		RadioButton otherRadio = new RadioButton("OTHER");
		VBox radioVBox = new VBox(10, sunsetRadio, desertRadio, otherRadio);
		radioVBox.setPadding(new Insets(30));
		
		// Select the sunset image by default
		sunsetRadio.setSelected(true);
		
		// Add the RadioButtons to a ToggleGroup
		ToggleGroup radioGroup = new ToggleGroup();
		sunsetRadio.setToggleGroup(radioGroup);
		desertRadio.setToggleGroup(radioGroup);
		otherRadio.setToggleGroup(radioGroup);
		
		// Register event handlers for the RadioButtons
		sunsetRadio.setOnAction(event -> {
			imageView.setImage(sunset);
		});
		desertRadio.setOnAction(event -> {
			imageView.setImage(desert);
		});
		otherRadio.setOnAction(event -> {
			imageView.setImage(other);
		});
		
		// Add everything to a VBox
		VBox mainVBox = new VBox(10, imageHBox, radioVBox);
		
		// Add vertical group to the scene and add the scene to the stage
		primaryStage.setTitle("Radio Buttons");
		Scene scene = new Scene(mainVBox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
