package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

/**
 * Custom extension of a JavaFX stage that allows injection of custom
 * controllers. These controllers are created by Spring, allowing me to
 * finally have control over their initialization process.
 */
public class FXMLStage extends Stage {

    /**
     * The controller for the stage
     */
    private Controller controller;

    /**
     * @param controller The controller for this component
     * @param fxml A URL pointing to an FXML document. This document
     *             represents the layout of the component
     * @param owner The window that owns this stage
     */
    public FXMLStage(Controller controller, URL fxml, Window
            owner){
        this(controller, fxml, owner, StageStyle.DECORATED);
    }

    /**
     * @param controller The controller for this component
     * @param fxml A URL pointing to an FXML document. This document
     *             represents the layout of the component
     * @param owner The window that owns this stage
     * @param style The styling for the stage
     */
    public FXMLStage(final Controller controller, URL fxml, Window owner,
                     StageStyle style){
        super(style);
        this.controller = controller;
        initOwner(owner);
        initModality(Modality.NONE);
        FXMLLoader loader = new FXMLLoader(fxml);

        configureLoader(loader);

        this.controller.setFXMLStage(this);

        loadFXML(loader);
    }

    public FXMLStage(Node component, Controller controller, URL fxml, Window
            owner){
        this(component, controller, fxml, owner, StageStyle.DECORATED);
    }

    public FXMLStage(Node component, Controller controller, URL fxml, Window
            owner, StageStyle style){
        super(style);
        this.controller = controller;
        initOwner(owner);
        initModality(Modality.NONE);
        FXMLLoader loader = new FXMLLoader(fxml);

        configureLoader(loader);
        loader.setRoot(component);

        this.controller.setFXMLStage(this);

        loadFXML(loader);
    }

    /**
     * Configure the stage's FXML to load the controller supplied in the
     * stage's constructor.
     * @param loader The FXMLLoader to configure
     */
    private void configureLoader(FXMLLoader loader){
        loader.setControllerFactory(
                (Class<?> aClass) -> controller
        );
    }

    /**
     * Load the FXML component
     * @param loader The loader to use for loading the component
     */
    private void loadFXML(FXMLLoader loader){
        try {
            setScene(new Scene((Parent) loader.load()));
        } catch (IOException error){
            throw new RuntimeException(error);
        }
    }
}
