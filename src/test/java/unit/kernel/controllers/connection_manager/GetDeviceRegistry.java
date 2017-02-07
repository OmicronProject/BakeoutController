package unit.kernel.controllers.connection_manager;

import kernel.controllers.ConnectionManager;
import kernel.controllers.DeviceRegistry;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for
 * {@link ConnectionManager#getDeviceRegistry()}
 */
public final class GetDeviceRegistry extends ConnectionManagerTestCase {
    private final DeviceRegistry registry = context.mock(DeviceRegistry.class);

    @Before
    public void setDeviceRegistry(){
        connectionManager.setDeviceRegistry(registry);
    }

    @Test
    public void getDeviceRegistry(){
        assertEquals(
                registry,
                connectionManager.getDeviceRegistry()
        );
    }
}
