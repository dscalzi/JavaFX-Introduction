package com.westhillcs.jfx.intro.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

/**
 * This is a controller class which will allow us to load
 * values we defined in our FXML document and modify them
 * as needed. This allows us to add pure java modifications
 * while still having FXML as the structure of our GUI.
 * 
 * Do some google searches for more in-depth explanations
 * of FXML controllers.
 * 
 * @author Daniel Scalzi
 *
 */
public class FXMLController implements Initializable{

	//Load in a Node from the FXML doc. The variable name
	//must match the name specified as the fx:id in the fxml.
	//If fx:id is not defined then it cannot load the node.
	@FXML private StackPane text_container;
	
	//This is the method we need to override to be a controller.
	//Usually this is where you can do some operations to set things
	//up in a more complicated GUI.
	@Override
	public void initialize(URL paramURL, ResourceBundle paramResourceBundle) {
		//Nothing to do here :)
	}
	
	/**
	 * This method will be referable in the FXML file because we've added
	 * the @FXML annotation. To reference a method in FXML simply write it like this:
	 * 
	 * #[methodName]
	 * 
	 * so we have
	 * 
	 * #handleClick
	 * 
	 * This will be used to handle ActionEvents for the button we defined in FXML.
	 * 
	 * @param e ActionEvent
	 */
	@FXML
	private void handleClick(ActionEvent e){
		text_container.setVisible(!text_container.isVisible());
	}

}
