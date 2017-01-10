package unit.kernel.port_manager.serial_port.serial_port;

import gnu.io.PortInUseException;
import kernel.port_manager.serial_port.SerialPort;
import org.jmock.Expectations;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Contains unit tests for {@link SerialPort#acquire()}
 */
public class Acquire extends SerialPortTestCase {
    @Test
    public void testHappyPath() throws PortInUseException {
        this.context.checking(new Expectations(){{
            oneOf(portIdentifier).open(ownerName, timeout);
        }});

        this.serialPort.acquire();
        assertTrue(this.serialPort.isPortOpen());
    }
}
