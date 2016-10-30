package HelloWorld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    @FXML private Text actionTarget;

    @FXML protected void sayHelloWorld(ActionEvent event){
        actionTarget.setText("The button has been pressed.");
    }

    /**
     * Tests that a click can successfully work
     *
     * @param stage The stage to which the test is supposed to be run
     * @throws Exception If unable to load the FXML file
     * @apiNote getClass.getResource() returns null silently if the resource
     *  cannot be found on the runtime classpath. Therefore, preface the
     *  file specification by a forward slash. This makes the tests pass
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/HelloWorld.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("The Button");
        stage.setScene(scene);
        stage.show();
    }
}