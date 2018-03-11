package com.westhillcs.jfx.intro;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * For full documentation, view the Oracle API. For your convenience, here is a link:
 * 
 * <a href="https://docs.oracle.com/javase/8/javafx/api/toc.htm">Oracle API</a>
 * 
 * @author Daniel Scalzi
 * @category JavaFX 8 Demo
 *
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/toc.htm">Oracle API</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html">Application</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Alert.html">Alert</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Alert.AlertType.html">AlertType</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ButtonType.html">ButtonType</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html">Optional</a>
 * @see <a href="http://code.makery.ch/blog/javafx-dialogs-official/">More Examples</a>
 *
 */
public class FX5AlertBox extends Application{

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Alert alert = new Alert(AlertType.CONFIRMATION); //Create a new Confirmation alert
		alert.setTitle("JavaFX Demo 5 - Confirmation Dialog");
		alert.setHeaderText("Congratulations on creating your first Alert Box!"); //Set the header text, null for no header
		alert.setContentText("Would you like to open up a webpage to view more examples?"); //Set the detail text

		Optional<ButtonType> result = alert.showAndWait(); //Display the alert and wait for a response. Store which button the user clicked
		//If the user clicked Okay
		if (result.get() == ButtonType.OK)
			Runtime.getRuntime().exec(new String[] { "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://code.makery.ch/blog/javafx-dialogs-official/" });
	}
	
}
