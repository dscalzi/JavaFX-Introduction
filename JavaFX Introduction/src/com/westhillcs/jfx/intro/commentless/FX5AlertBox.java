package com.westhillcs.jfx.intro.commentless;

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
 */
public class FX5AlertBox extends Application{

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("JavaFX Demo 5 - Confirmation Dialog");
		alert.setHeaderText("Congratulations on creating your first Alert Box!");
		alert.setContentText("Would you like to open up a webpage to view more examples?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK)
			Runtime.getRuntime().exec(new String[] { "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://code.makery.ch/blog/javafx-dialogs-official/" });
	}
	
}
