package com.westhillcs.jfx.intro.commentless;

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
 */
public class FX2UserEventsDemo1 extends Application implements EventHandler<ActionEvent>{

	Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Demo 2 - User Events 1");
        button = new Button();
        button.setText("Click me");
        button.setOnAction(this);
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

	@Override
	public void handle(ActionEvent event) {
		
		if(event.getSource() == button){
			System.out.println("Button was clicked!");
		}
		
	}
	
}
