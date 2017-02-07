package unit.kernel.controllers.connection_manager;

import kernel.controllers.ConnectionManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link ConnectionManager#getDeviceToConnect()}
 */
public final class GetDeviceToConnect extends ConnectionManagerTestCase {
    @Before
    public void setDevice(){
        connectionManager.setDeviceToConnect(deviceListEntry);
    }

    @Test
    public void getDevice(){
        assertEquals(deviceListEntry, connectionManager.getDeviceToConnect());
    }
}
