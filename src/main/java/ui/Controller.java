package ui;

/**
 * Base interface defining a controller. Controllers are beans that contain
 * \@FXML fields. These fields are injected into the bean by JavaFX, and the
 * handlers defined in these controllers are used to perform actions
 */
public interface Controller {
    /**
     * Sets the stage for this controller. A stage is the top-most element
     * of a JavaFX UI.
     * @param stage The stage to set
     */
    void setFXMLStage(FXMLStage stage);
}
