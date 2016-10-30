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

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HelloWorld.fxml"));

        stage.setTitle("The Button");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }
}