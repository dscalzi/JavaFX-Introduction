package com.westhillcs.jfx.intro;

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
 *
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/toc.htm">Oracle API</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html">Application</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html">Label</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/VBox.html">VBox</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/HBox.html">HBox</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Pos.html">Pos</a>
 *
 */
public class FX4SceneControl extends Application{

	Stage window;
	Scene scene1, scene2;
	
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.window = primaryStage; //Assign our custom variable window to the primary stage.
		
		/* Scene 1 */
		Label lblHeader1 = new Label("Welcome to scene 1.");
		Button btnSwitch1 = new Button("Switch to scene 2");
		btnSwitch1.setOnAction(e -> window.setScene(scene2)); //When this button is clicked, switch to scene 2
		
		//Vertical layout for scene 1
		VBox layout1 = new VBox(20); //New VBox layout.
		layout1.getChildren().addAll(lblHeader1, btnSwitch1); //Add the label and button to the layout
		layout1.setAlignment(Pos.CENTER); //Add center alignment for this VBox
		scene1 = new Scene(layout1, 500, 200); //Instantiate  the scene
		
		
		/* Scene 2 */
		Button btnSwitch2 = new Button("Return to scene 1");
		btnSwitch2.setOnAction(e -> window.setScene(scene1)); //When this button is clicked, switch to scene 1
		
		//Horizontal layout for scene 2
		HBox layout2 = new HBox(20); //New HBox layout.
		layout2.getChildren().addAll(new Label("Nothing to see here.."), btnSwitch2); //Add the label and button to the layout
		layout2.setAlignment(Pos.CENTER); //Add center alignment for this HBox
		scene2 = new Scene(layout2, 500, 200); //Instantiate the scene
		
		
		/* Set default scene etc*/
		window.setScene(scene1);
		window.setTitle("JavaFX Demo 4 - Scene Control");
		window.show();
		
	}
	
}
