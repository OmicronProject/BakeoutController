package ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.*;
import ui.controllers.DevicesController;

/**
 * Contains the configuration for the User Interface. This is a structure of
 * beans that are used to load the user interface. Construction details are
 * specified in this configuration
 *
 * @apiNote IntelliJ will claim that some methods, especially the beans, are
 * unused. This is false. These methods need to exist because Spring will
 * run all the methods annotated with {@link Bean}, and add their return values
 * to its inversion of control container. Calls to
 * {@link org.springframework.context.ApplicationContext#getBean(Class)}
 * will then use these instantiated objects. Such a call is also implicitly
 * present in any field annotated with
 * {@link org.springframework.beans.factory.annotation.Autowired}. In short,
 * be sure that methods can be deleted from here before you do so. Your IDE
 * may spread lies
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
     * @return An FXML loader awqre of this application context
     */
    @Bean
    @Scope("prototype")
    public FXMLLoader fxmlLoader(){
        return new ContextAwareFXMLLoader();
    }

    @Bean
    @Scope("prototype")
    public DevicesController devicesController(){
        return new DevicesController();
    }

    /**
     * @return A loaded user interface
     */
    @Bean
    @Scope("singleton")
    public FXMLStage application(){
        return new AutowiredFXMLStage(
            getClass().getResource("/Application.fxml"),
            primaryStage
        );
    }


}
