package application;
	
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Create a new menu
			//Menu will contain four items:
			//1. Display current date and time in a text field
			//2. Save the displayed date and time to a file called "log.txt"
			//3. Change the background to different shades of green (random)
			//4. Exit the program
			Menu menu = new Menu("Menu");
			MenuItem dateTime = new MenuItem("Display Date and Time");
			MenuItem saveText = new MenuItem("Save Date and Time");
			MenuItem changeColor = new MenuItem("Change Background Color");
			MenuItem exit = new MenuItem("Exit");
			//Add all menu items to the menu
			menu.getItems().addAll(dateTime, saveText, changeColor, exit);
			
			//Create menu bar to items to fit in
			MenuBar menuBar = new MenuBar();
			menuBar.getMenus().add(menu);
			
			//Instantiate date variable
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			TextField textField = new TextField();
			textField.setText("Date and Time");
			//Menu button sets text field to current date and time
			dateTime.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					textField.setText(dateFormat.format(date));
				}
			});
			
			//Menu item saves current textfield items to a file named "log.txt"
			//using file output stream
			saveText.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					FileOutputStream outputStream;
					try {
						outputStream = new FileOutputStream("log.txt");
						PrintWriter outFS = new PrintWriter(outputStream);
						outFS.println(textField.getText());
						outFS.close();
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			
			//Create general layout of application
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 500, 500);
			Stage stage = new Stage();
			stage.setTitle("Menu Example");
			stage.setScene(scene);
			stage.show();
			root.setTop(menuBar);
			
			//Create horizontal box in top right of border pane
			//Textfield will fit inside hbox
			HBox hBox = new HBox();
			hBox.getChildren().add(textField);
			root.setRight(hBox);
			
			//Menu item changes background color to random shade of green
			changeColor.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Random rand = new Random();
					Color randColor = new Color(0, rand.nextDouble(), 0, rand.nextDouble());					
					root.setBackground(new Background(new BackgroundFill(randColor, null, null)));
				}
			});
			
			//Menu item closes window and terminates program
			exit.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Platform.exit();
				}	
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//main method used to launch program
	public static void main(String[] args) {
		launch(args);
	}
}
