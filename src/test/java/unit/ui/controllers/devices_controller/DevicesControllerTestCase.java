package unit.ui.controllers.devices_controller;

import javafx.scene.control.Button;
import org.junit.Before;
import unit.ui.controllers.ControllersTestCase;

/**
 * Base class for unit testing {@link ui.controllers.DevicesController}
 */
public abstract class DevicesControllerTestCase extends ControllersTestCase {
    protected Button newDeviceButton;

    protected final String queryForNewDeviceButton = "#newDeviceButton";
    protected final String queryForNewDeviceForm = "#newDeviceForm";

    @Before
    public void setNewDeviceButton(){
        newDeviceButton = lookup(queryForNewDeviceButton).query();
    }
}
