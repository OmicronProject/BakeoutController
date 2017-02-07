package unit.kernel.controllers.connection_manager;

import kernel.controllers.ConnectionManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for
 * {@link ConnectionManager#getPortName()}
 */
public final class GetPortName extends ConnectionManagerTestCase {
    private final String portName = "/dev/ttyUSB0";

    @Before
    public void setPortName(){
        connectionManager.setPortName(portName);
    }

    @Test
    public void getPortName(){
        assertEquals(
                portName,
                connectionManager.getPortName()
        );
    }
}
