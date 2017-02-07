package unit.kernel.controllers.connection_manager;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for
 * {@link kernel.controllers.ConnectionManager#setPortName(String)}
 */
public final class SetPortName extends ConnectionManagerTestCase {
    private static final String portName = "/dev/ttyUSB0";

    @Test
    public void setPortName(){
        connectionManager.setPortName(portName);

        assertEquals(
                portName,
                connectionManager.getPortName()
        );
    }
}
