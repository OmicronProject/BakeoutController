package ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.*;
import ui.controllers.SetupPanelController;

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

    @Bean
    @Scope("prototype")
    FXMLLoader fxmlLoader(){
        return new FXMLLoader();
    }

    @Bean
    SetupPanelController setupPanelController(){
        return new SetupPanelController();
    }

    @Bean
    @Scope("singleton")
    FXMLStage application(){
        return new FXMLStage(
            getClass().getResource("/Application.fxml"),
            primaryStage
        );
    }
}
