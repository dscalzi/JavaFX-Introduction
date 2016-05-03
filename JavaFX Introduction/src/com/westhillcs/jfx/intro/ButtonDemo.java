package com.westhillcs.jfx.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html">Application Class</a>
 *
 */
public class ButtonDemo extends Application{

	Button button;

    public static void main(String[] args) {
    	/*
    	 * This will launch the current application. Since our current class inherits from Application,
    	 * we can simply call launch on it. This is the equivalent of ButtonDemo.launch(), since launch is static.
    	 */
        launch(args);
    }

    /**
     * This is the method that will start your JavaFX Application. All of your initialization should be invoked by this method.
     * 
     * @param primaryStage The main stage of the application that will be brought up.
     * 
     * @throws Exception As specified by the <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html#start-javafx.stage.Stage-">Oracle API</a>, the method is written to throw a generic exception, therefore we will include it.
     * 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Demo 1 - Buttons"); //Set window title
        
        /* Button Work */
        button = new Button(); //Initialize Button
        button.setText("Click me"); //Set button text
        
        /* Layout work */
        StackPane layout = new StackPane(); //Create a new layout
        layout.getChildren().add(button); //Add the button to the layout
        
        /* Scene work */
        Scene scene = new Scene(layout, 300, 250); //Create a new scene with the desired layout, width, and height
        
        /* Set the stage */
        primaryStage.setScene(scene); //Set the stage's scene to the one we just created
        primaryStage.show(); //Show our stage (window)
    }
	
}
