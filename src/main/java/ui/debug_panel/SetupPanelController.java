package ui.debug_panel;

import kernel.Kernel;
import org.springframework.beans.factory.annotation.Autowired;
import ui.Controller;
import ui.FXMLStage;

/**
 * Controller for the setup Panel
 */
public class SetupPanelController implements Controller {
    private FXMLStage stage;

    @Autowired
    private Kernel kernel;

    @Override
    public void setFXMLStage(FXMLStage stage) {
        this.stage = stage;
    }
}
