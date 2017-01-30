package ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import ui.hello_world.HelloWorldController;

/**
 * Created by mkononen on 30/01/17.
 */
@Configuration
@Lazy
public class UserInterfaceConfiguration {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showScreen(Parent screen){
        primaryStage.setScene(new Scene(screen, 500, 400));
        primaryStage.show();
    }

    @Bean
    HelloWorldController helloWorldController(){
        return new HelloWorldController();
    }

    @Bean
    @Scope("prototype")
    FXMLStage helloWorld(){
        return new FXMLStage(
            helloWorldController(),
            getClass().getResource("/HelloWorld.fxml"),
            primaryStage
        );
    }
}
