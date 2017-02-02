package unit.ui.controllers.sequence_controller;

import javafx.scene.layout.Pane;
import org.junit.Test;
import ui.controllers.SequenceController;

import static org.junit.Assert.assertNotNull;

/**
 * contains unit tests for {@link SequenceController#displayNewStepForm()}
 */
public final class DisplayNewStepForm extends SequenceControllerTestCase {
    private static final String queryForNewStepButton = "#new-step-button";
    private static final String queryForNewStepForm = "#new-step-form";

    @Test
    public void newStepForm(){
        clickOn(queryForNewStepButton);
        assertNotNull(lookupNewStepForm());
    }

    private Pane lookupNewStepForm(){
        return lookup(queryForNewStepForm).query();
    }
}
