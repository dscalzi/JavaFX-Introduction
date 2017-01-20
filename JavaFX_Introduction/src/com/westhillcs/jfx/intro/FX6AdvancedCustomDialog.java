package com.westhillcs.jfx.intro;
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
 *
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Dialog.html">Dialog<R></a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/util/Pair.html">Pair</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html">GridPane</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html">TextField</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/PasswordField.html">PasswordField</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html">Node</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/StringProperty.html">StringProperty</a>
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/beans/value/ChangeListener.html">ChangeListener<T></a>
 * @see <a href="http://docs.oracle.com/javase/8/javafx/api/javafx/application/Platform.html">Platform</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html">Runnable</a>
 * @see <a href="http://docs.oracle.com/javase/8/javafx/api/javafx/util/Callback.html">Callback<P,R></a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html">Consumer</a>
 */
public class FX6AdvancedCustomDialog extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	// Create the custom dialog.
    	/**
    	 * Dialog is defined as Dialog<R> = new Dialog<>;
    	 * R is the element that the result will be after the user finishes.
    	 * 
    	 * In our case we want a pair of strings (Pair<String, String>). The first
    	 * value is the key, the second is the value. The username will be the key while
    	 * the password will be the value. Later in the code we will write instructions
    	 * so that the dialog knows where to retrieve these values.
    	 */
    	Dialog<Pair<String, String>> dialog = new Dialog<>();
    	dialog.setTitle("Login Dialog");
    	dialog.setHeaderText("Look, a Custom Login Dialog");

    	// Set the icon (must be included in the project).
    	//dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

    	// Set the button types.
    	ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
    	dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

    	// Create the username and password labels and fields.
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

    	// Enable/Disable login button depending on whether a username was entered.
    	Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType); //Get the instance of the login button
    	loginButton.setDisable(true);

    	// Do some validation (using the Java 8 lambda syntax).
    	// The listener being written is a new ChangeListener().
    	username.textProperty().addListener((observable, oldValue, newValue) -> {
    	    loginButton.setDisable(newValue.trim().isEmpty());
    	});

    	dialog.getDialogPane().setContent(grid);

    	// Request focus on the username field by default.
    	// Lambda here is that of public void run(), creating a new Runnable().
    	Platform.runLater(() -> username.requestFocus());

    	/* CRITICAL STEP */
    	// Convert the result to a username-password-pair when the login button is clicked.
    	// Lambda here is creating a new Callback<P,R>(), the method being call.
    	/** In english, what this method is doing is establishing a way for the data collected in
    	 * the Dialog to be returned after the user closes it. This is a critical step in creating
    	 * a custom dialog as ClassCastExceptions will be thrown. For more details on this, check the
    	 * Oracle JFX8 API.
    	 * 
    	 * dialogButton is the parameter to the method. If the dialogButton is of the type 
    	 * loginButtonType, then the user has clicked the login button and we will return a
    	 * pair of String data, the username text and the password text.
    	 * If the dialogButton is not of the type loginButtonType, then the user either canceled or
    	 * closed the window. In this case the dialog will return null.
    	 * 
    	 */
    	dialog.setResultConverter(dialogButton -> {
    	    if (dialogButton == loginButtonType) {
    	        return new Pair<>(username.getText(), password.getText());
    	    }
    	    return null;
    	});

    	
    	// This will display the dialog and wait. Once the user has finished with it, the result will be
    	// determined from the resultConverter property written above. That data will be stored.
    	Optional<Pair<String, String>> result = dialog.showAndWait();

    	/**
    	 * This is a fancy way of writing "if a value is present inside our optional variable result,
    	 * print out the key (username) and value (password) stored inside of it."
    	 * 
    	 * The ifPresent method will invoke a new Consumer if the value stored inside the Optional is
    	 * not null. The Consumer method used in the lambda below is accept with the parameter forced into
    	 * an instance of a Pair<String, String>. This accept method simply executes the code you write inside of it.
    	 */
    	result.ifPresent(usernamePassword -> {
    	    System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
    	});
    }


}