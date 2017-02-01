package ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URL;

/**
 * Custom extension of a JavaFX stage that allows injection of custom
 * controllers. These controllers are created by Spring, allowing me to
 * finally have control over their initialization process.
 */
public class AutowiredFXMLStage extends Stage implements FXMLStage {

    /**
     * The loader to use for loading FXML. This loader is supplied by
     * Spring, and is aware of the current application context
     *
     * @implNote IntelliJ claims that this loader is never assigned. This is
     * because spring does it automatically by the
     * {@link Autowired} annotation.
     */
    @Autowired
    private FXMLLoader fxmlLoader;

    /**
     * The FXML resource that the loader for this stage needs to load.
     */
    private URL fxml;

    /**
     * @param fxml A URL pointing to an FXML document. This document
     *             represents the layout of the component
     * @param owner The window that owns this stage
     */
    public AutowiredFXMLStage(URL fxml, Window owner){
        this(fxml, owner, StageStyle.DECORATED);
    }

    /**
     * @param fxml A URL pointing to an FXML document. This document
     *             represents the layout of the component
     * @param owner The window that owns this stage
     * @param style The styling for the stage
     */
    public AutowiredFXMLStage(URL fxml, Window owner,
                              StageStyle style){
        super(style);
        this.fxml = fxml;
        initOwner(owner);
        initModality(Modality.NONE);
    }

    /**
     * Load the FXML component
     */
    public void loadFXML() throws IOException {
        this.fxmlLoader.setLocation(this.fxml);
        setScene(new Scene((Parent) this.fxmlLoader.load()));
    }
}