package com.westhillcs.jfx.intro.fxml;

import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This won't be too fancy, just to show the basics. FXML is a powerful tool, capable
 * of property binding and reducing the size of your code by a significant amount once
 * your GUI becomes larger, more complicated, and more powerful. I encourage you to do
 * individual research on this topic and create GUIs using this method, I can assure you
 * it will me much simpler than the pure Java alternative.
 * 
 * @author Daniel Scalzi
 *
 */
public class FXMLMain extends Application{

	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Object to load and read the FXML
		FXMLLoader loader = new FXMLLoader();
		
		VBox root;
		
		/*
		 * Retrieve our fxml file as an InputStream and use that to call the FXMLLoader's
		 * load method. Cast the object based on the Node you defined first
		 * in your FXML file. In our case, we used a VBox.
		 * 
		 * This is a try-with-resource block. All it does is makes sure that
		 * the InputStream is closed when we finish the try code, regardless of
		 * whether or not an exception is thrown. 
		 */
		try(InputStream fxmlStream = getClass().getResourceAsStream("GUILayout.fxml")){
			root = (VBox) loader.load(fxmlStream);
		}
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("FXML Demo");
		primaryStage.show();
	}

}
