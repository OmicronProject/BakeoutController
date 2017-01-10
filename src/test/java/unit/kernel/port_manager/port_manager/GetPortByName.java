package unit.kernel.port_manager.port_manager;

import gnu.io.NoSuchPortException;
import kernel.port_manager.serial_port.SerialPort;
import org.jmock.Expectations;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Contains unit tests for
 * {@link kernel.port_manager.PortManager#getPortByName(String)}
 */
public class GetPortByName extends PortManagerTestCase {
    protected final String portName = "/dev/ttyUSB0";

    /**
     * Walks through the test's happy path
     * @throws NoSuchPortException if the method throws the exception
     */
    @Test
    public void getPortByName() throws NoSuchPortException {
        this.context.checking(new Expectations(){{
            oneOf(mockAdapter).getCommPortIdentifier(portName);
        }});

        SerialPort port = this.portManager.getPortByName(portName);

        assertNotNull(port);
    }
}
