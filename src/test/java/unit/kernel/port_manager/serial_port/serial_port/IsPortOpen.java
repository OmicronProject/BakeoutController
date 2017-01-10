package unit.kernel.port_manager.serial_port.serial_port;

import gnu.io.PortInUseException;
import org.jmock.Expectations;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mkononen on 10/01/17.
 */
public class IsPortOpen extends SerialPortTestCase {
    @Test
    public void isPortOpenTrue() throws PortInUseException {
        this.context.checking(new Expectations(){{
            oneOf(portIdentifier).open(ownerName, timeout);
            will(returnValue(commPort));
        }});

        this.serialPort.acquire();

        assertTrue(this.serialPort.isPortOpen());
    }

    @Test
    public void isPortOpenFalse() throws PortInUseException {
        this.context.checking(new Expectations(){{
            oneOf(portIdentifier).open(ownerName, timeout);
            will(returnValue(commPort));
            oneOf(commPort).close();
        }});

        this.serialPort.acquire();
        this.serialPort.release();

        assertFalse(this.serialPort.isPortOpen());
    }
}
