package ui;

import javafx.stage.Stage;

import java.io.IOException;

/**
 * Describes the role of the main class of the User Interface
 */
public interface JavaFXApplication {
    /**
     * Start the user interface
     */
    void start(Stage stage) throws IOException;

    void launchApplication(String[] args);
}
