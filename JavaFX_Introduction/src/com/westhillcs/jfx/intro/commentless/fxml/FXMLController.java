package com.westhillcs.jfx.intro.commentless.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

/**
 * @author Daniel Scalzi
 */
public class FXMLController implements Initializable{

	@FXML private StackPane text_container;
	
	@Override
	public void initialize(URL paramURL, ResourceBundle paramResourceBundle) {
		//Nothing to do here :)
	}
	
	@FXML
	private void handleClick(ActionEvent e){
		text_container.setVisible(!text_container.isVisible());
	}

}
