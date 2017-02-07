package unit.kernel.controllers.connection_manager;


import kernel.views.DeviceListEntry;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for
 * {@link kernel.controllers.ConnectionManager#setDeviceToConnect(DeviceListEntry)}
 */
public final class SetDeviceToConnect extends ConnectionManagerTestCase {
    @Test
    public void setDeviceToConnect(){
        connectionManager.setDeviceToConnect(deviceListEntry);

        assertEquals(deviceListEntry, connectionManager.getDeviceToConnect());
    }
}
