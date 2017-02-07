package unit.kernel.controllers.connection_manager;

import kernel.controllers.ConnectionManager;
import kernel.controllers.DeviceConnector;
import kernel.views.DeviceListEntry;
import org.junit.Before;
import unit.ui.controllers.ControllersTestCase;

/**
 * Base class for tests of {@link kernel.controllers.ConnectionManager}
 */
public abstract class ConnectionManagerTestCase extends ControllersTestCase {
    protected DeviceConnector connectionManager;
    protected DeviceListEntry deviceListEntry;

    @Before
    public void setDeviceConnector(){
        connectionManager = new ConnectionManager();
    }

    @Before
    public void setDeviceListEntry(){
        deviceListEntry = context.mock(DeviceListEntry.class);
    }
}
