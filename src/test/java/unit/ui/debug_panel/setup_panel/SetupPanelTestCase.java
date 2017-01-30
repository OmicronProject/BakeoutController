package unit.ui.debug_panel.setup_panel;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import org.junit.Before;
import unit.ui.debug_panel.DebugPanelTestCase;

/**
 * Created by mkononen on 30/01/17.
 */
public abstract class SetupPanelTestCase extends DebugPanelTestCase {
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
