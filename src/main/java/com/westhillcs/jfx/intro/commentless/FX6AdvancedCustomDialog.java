package com.westhillcs.jfx.intro.commentless;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 * For full documentation, view the Oracle API. For your convenience, here is a link:
 * 
 * <a href="https://docs.oracle.com/javase/8/javafx/api/toc.htm">Oracle API</a>
 * 
 * @author Marco Jakob
 * @category JavaFX 8 Demo
 *
 * @see <a href="http://code.makery.ch/blog/javafx-dialogs-official/">More Examples</a>
 */
public class FX6AdvancedCustomDialog extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	Dialog<Pair<String, String>> dialog = new Dialog<>();
    	dialog.setTitle("Login Dialog");
    	dialog.setHeaderText("Look, a Custom Login Dialog");

    	ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
    	dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

    	GridPane grid = new GridPane();
    	grid.setHgap(10);
    	grid.setVgap(10);
    	grid.setPadding(new Insets(20, 150, 10, 10));

    	TextField username = new TextField();
    	username.setPromptText("Username");
    	PasswordField password = new PasswordField();
    	password.setPromptText("Password");

    	grid.add(new Label("Username:"), 0, 0);
    	grid.add(username, 1, 0);
    	grid.add(new Label("Password:"), 0, 1);
    	grid.add(password, 1, 1);

    	Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
    	loginButton.setDisable(true);

    	username.textProperty().addListener((observable, oldValue, newValue) -> {
    	    loginButton.setDisable(newValue.trim().isEmpty());
    	});

    	dialog.getDialogPane().setContent(grid);

    	Platform.runLater(() -> username.requestFocus());

    	/* CRITICAL STEP */
    	dialog.setResultConverter(dialogButton -> {
    	    if (dialogButton == loginButtonType) {
    	        return new Pair<>(username.getText(), password.getText());
    	    }
    	    return null;
    	});

    	Optional<Pair<String, String>> result = dialog.showAndWait();

    	result.ifPresent(usernamePassword -> {
    	    System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
    	});
    }


}