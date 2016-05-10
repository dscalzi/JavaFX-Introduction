package com.westhillcs.jfx.intro;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html">Application</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/event/EventHandler.html">EventHandler</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/event/ActionEvent.html">ActionEvent</a>
 * 
 */
public class FX3UserEventsDemo2 extends Application{

	Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Demo 2 - User Events 2");
        
        /* Button Work */
        button = new Button();
        button.setText("Click me");
        button.setOnAction(new EventHandler<ActionEvent>() { //Handle event via an anonymous inner class.
        	@Override
        	public void handle(ActionEvent event){
        		System.out.println("Button was pressed!");
        	}
        });
        
        /* Using Java 8 Lambda
         * 
         * button.setOnAction(e -> System.out.println("Button was pressed!"));
         * 
         * For multiple lines of code
         * 
         * button.setOnAction(e -> {
         * 	  System.out.println("Button was pressed!");
         *    System.out.println("Some other line here!");
         * });
         * 
         */
        
        /* Layout work */
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        
        /* Scene work */
        Scene scene = new Scene(layout, 300, 250);
        
        /* Set the stage */
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
}
