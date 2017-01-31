package unit.ui.controllers.setup_panel_controller;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import org.junit.Before;
import unit.ui.UserInterfaceTestCase;

/**
 * Base class for testing {@link ui.controllers.SetupPanelController}
 */
public abstract class SetupPanelControllerTestCase extends UserInterfaceTestCase {
    protected Button updateButton;
    protected ComboBox<String> availablePortsDropdown;

    @Before
    public void setUpdateButton(){
        updateButton = lookup("#updateButton").query();
    }

    @Before
    public void setAvailablePortsDropdown(){
        availablePortsDropdown = lookup("#availablePortsDropdown").query();
    }
}
