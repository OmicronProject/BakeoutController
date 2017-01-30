package ui.hello_world;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import ui.Controller;
import ui.FXMLStage;

/**
 * Contains the controller for working with a super-simple Hello World UI
 */
public class HelloWorldController implements Controller {
    /**
     * The stage used for the controller
     */
    private FXMLStage stage;

    /**
     * The text to which the result of the button action is to be written
     */
    @FXML private Text actionTarget;

    /**
     * @param stage The stage to set
     */
    @Override public void setFXMLStage(FXMLStage stage){
        this.stage = stage;
    }

    /**
     * Perform the action when the button is clicked
     */
    @FXML public void sayHello(){
        actionTarget.setText("The button was pressed");
    }
}
