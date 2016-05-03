package com.westhillcs.jfx.intro.commentless;

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
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Demo 1 - Buttons");
        button = new Button();
        button.setText("Click me");
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
}
