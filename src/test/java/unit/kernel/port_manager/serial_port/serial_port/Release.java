package unit.kernel.port_manager.serial_port.serial_port;

import gnu.io.PortInUseException;
import kernel.port_manager.serial_port.SerialPort;
import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Contains unit tests for {@link SerialPort#release()}
 */
public class Release extends SerialPortTestCase {
    @Before
    public void setUpOpenPort() throws PortInUseException {
        this.context.checking(new Expectations(){{
            oneOf(portIdentifier).open(ownerName, timeout);
            will(returnValue(commPort));
        }});

        this.serialPort.acquire();

        assertTrue(this.serialPort.isPortOpen());
    }

    @Test
    public void testHappyPath(){
        this.context.checking(new Expectations(){{
            oneOf(commPort).close();
        }});

        this.serialPort.release();
        assertFalse(this.serialPort.isPortOpen());
    }
}
