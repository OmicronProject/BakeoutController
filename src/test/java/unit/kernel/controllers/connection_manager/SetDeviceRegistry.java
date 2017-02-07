package unit.kernel.controllers.connection_manager;

import kernel.controllers.DeviceRegistry;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for
 * {@link kernel.controllers.ConnectionManager#setDeviceRegistry(DeviceRegistry)}
 *
 */
public final class SetDeviceRegistry extends ConnectionManagerTestCase {
    private DeviceRegistry registry = context.mock(DeviceRegistry.class);

    @Test
    public void setDeviceRegistry(){
        connectionManager.setDeviceRegistry(registry);

        assertEquals(
                registry,
                connectionManager.getDeviceRegistry()
        );
    }
}
