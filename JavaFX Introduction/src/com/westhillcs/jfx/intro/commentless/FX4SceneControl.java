package com.westhillcs.jfx.intro.commentless;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * For full documentation, view the Oracle API. For your convenience, here is a link:
 * 
 * <a href="https://docs.oracle.com/javase/8/javafx/api/toc.htm">Oracle API</a>
 * 
 * @author Daniel Scalzi
 * @category JavaFX 8 Demo
 */
public class FX4SceneControl extends Application{

	Stage window;
	Scene scene1, scene2;
	
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.window = primaryStage;
		
		/* Scene 1 */
		Label lblHeader1 = new Label("Welcome to scene 1.");
		Button btnSwitch1 = new Button("Switch to scene 2");
		btnSwitch1.setOnAction(e -> window.setScene(scene2));
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(lblHeader1, btnSwitch1);
		layout1.setAlignment(Pos.CENTER);
		scene1 = new Scene(layout1, 500, 200);
		
		
		/* Scene 2 */
		Button btnSwitch2 = new Button("Return to scene 1");
		btnSwitch2.setOnAction(e -> window.setScene(scene1));
		HBox layout2 = new HBox(20);
		layout2.getChildren().addAll(new Label("Nothing to see here.."), btnSwitch2);
		layout2.setAlignment(Pos.CENTER);
		scene2 = new Scene(layout2, 500, 200);
		
		window.setScene(scene1);
		window.setTitle("JavaFX Demo 4 - Scene Control");
		window.show();
		
	}
	
}
