package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import main.ApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main entry point for the UI
 */
public class UserInterfaceLauncher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                ApplicationConfiguration.class
        );

        UserInterfaceConfiguration userInterface = context.getBean(
            UserInterfaceConfiguration.class
        );

        userInterface.setPrimaryStage(stage);
        userInterface.helloWorld().show();
    }
}
