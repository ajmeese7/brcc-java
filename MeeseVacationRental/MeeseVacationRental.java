/*
 * MeeseVacationRental.java
 * Author: Aaron Meese
 * Date: 3/28/19
 * 
 * This is a GUI application that receives user
 * input about the specifics of their vacation 
 * booking and displays the total price.
 * 
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MeeseVacationRental extends Application {
	
	public static void main(String[] args) {
		// Launch the application.
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Lambert's Vacation Rentals");

		// Declare images
		Image parkside = new Image("file:src/parkside.jpg");
		Image poolside = new Image("file:src/poolside.jpg");
		Image lakeside = new Image("file:src/lakeside.jpg");
		ImageView imageView = new ImageView(parkside);
		
		// Resize the ImageView and ignore aspect ratio because images are different sizes
		imageView.setFitWidth(500);
		imageView.setFitHeight(300);

		// Create combo boxes & list and add them to horizontal group
		ComboBox<String> location = new ComboBox<>();
		location.getItems().addAll("Parkside", "Poolside", "Lakeside");
		location.setOnAction(new EventHandler<ActionEvent>() {
			// Changes the displayed image when the selected location changes
			public void handle(ActionEvent event) {
				int locationSelected = location.getSelectionModel().getSelectedIndex();
				if (locationSelected == 0) {
					imageView.setImage(parkside);
				} else if (locationSelected == 1) {
					imageView.setImage(poolside);
				} else if (locationSelected == 2) {
					imageView.setImage(lakeside);
				}
			}
		});
		
		ComboBox<Integer> rooms = new ComboBox<>();
		rooms.getItems().addAll(1, 2, 3);
		ListView<String> meals = new ListView<>();
		meals.getItems().addAll("Yes", "No");
		meals.setPrefSize(100, 60);
		Button calculate = new Button("Calculate Price");
		
		HBox options = new HBox(25, location, rooms, meals, calculate);
		options.setAlignment(Pos.CENTER);
		options.setPadding(new Insets(10));
		options.setMinWidth(500);
		
		Label priceDisplay = new Label();
		
		// Create event handler for button
		calculate.setOnAction(event -> {
			int price = 0;
			
			int locationNumber = location.getSelectionModel().getSelectedIndex();
			if (locationNumber == 0) {
				price += 600;
			} else if (locationNumber == 1) {
				price += 750;
			} else if (locationNumber == 2) {
				price += 825;
			}
			
			int numRooms = rooms.getSelectionModel().getSelectedItem();
			price += (numRooms - 1) * 75;
			
			int addMeals = meals.getSelectionModel().getSelectedIndex();
			if (addMeals == 0) {
				price += 200;
			}
			
			priceDisplay.setText("$" + price);
		});
		
		VBox vbox = new VBox(15, imageView, options, priceDisplay);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(5));
		
		// Add vertical group to the scene and add the scene to the stage
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
