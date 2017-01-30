package ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import ui.debug_panel.SetupPanel;
import ui.debug_panel.SetupPanelController;
import ui.hello_world.HelloWorldController;

/**
 * Contains the configuration for the User Interface. This is a structure of
 * beans that are used to load the user interface. Construction details are
 * specified in this configuration
 */
@Configuration
@Lazy
public class UserInterfaceConfiguration {
    /**
     * The stage in which the UI is to be displayed
     */
    private Stage primaryStage;

    /**
     * @param primaryStage The stage to use as the primary stage
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Show a particular modal dialog
     * @param screen The screen to show
     */
    public void showScreen(Parent screen){
        primaryStage.setScene(new Scene(screen, 500, 400));
        primaryStage.show();
    }

    /**
     * The controller for this application
     * @return The controller
     */
    @Bean
    HelloWorldController helloWorldController(){
        return new HelloWorldController();
    }

    /**
     * @return The Hello World component
     */
    @Bean
    @Scope("prototype")
    FXMLStage helloWorld(){
        return new FXMLStage(
            helloWorldController(),
            getClass().getResource("/HelloWorld.fxml"),
            primaryStage
        );
    }

    @Bean
    SetupPanelController setupPanelController(){
        return new SetupPanelController();
    }

    @Bean
    @Scope("prototype")
    FXMLStage setupPanel(){
        return new FXMLStage(
            new SetupPanel(),
            setupPanelController(),
            getClass().getResource("/debug_panel/SetupPanel.fxml"),
            primaryStage
        );
    }
}
