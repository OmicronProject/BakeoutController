package ui.hello_world;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import ui.Controller;
import ui.FXMLStage;

/**
 * Created by mkononen on 30/01/17.
 */
public class HelloWorldController implements Controller {
    private FXMLStage stage;

    @Override public void setFXMLStage(FXMLStage stage){
        this.stage = stage;
    }

    @FXML private Text actionTarget;

    @FXML public void sayHello(){
        actionTarget.setText("The button was pressed");
    }
}
