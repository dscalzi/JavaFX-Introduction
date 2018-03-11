package com.westhillcs.jfx.intro.commentless.fxml;

import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** 
 * @author Daniel Scalzi
 */
public class FXMLMain extends Application{

	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		
		VBox root;
		
		try(InputStream fxmlStream = getClass().getResourceAsStream("GUILayout.fxml")){
			root = (VBox) loader.load(fxmlStream);
		}
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("FXML Demo");
		primaryStage.show();
	}

}
