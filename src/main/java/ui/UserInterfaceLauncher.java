package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Base class for the UI. Responsible for launching the app
 */
public final class UserInterfaceLauncher extends Application
        implements JavaFXApplication {

    private Pane rootPane;

    public UserInterfaceLauncher() {
        super();
    }

    /**
     * Start the application
     * @param stage The Java FX Stage (an abstract representation of the
     *              Window that the application will run in) that the
     *              BakeoutController will populate with graphical elements
     */
    @Override public void start(Stage stage) throws IOException {
        stage.setTitle("RS232 Debug Console");
        rootPane = FXMLLoader.load(
                getClass().getResource("/Application.fxml")
        );
        Scene scene = new Scene(rootPane, 300, 275);
        stage.setScene(scene);

        stage.show();
    }

    @Override public void launchApplication(String[] args){
        launch(args);
    }
}
