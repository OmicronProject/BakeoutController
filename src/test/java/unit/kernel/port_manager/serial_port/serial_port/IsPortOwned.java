package unit.kernel.port_manager.serial_port.serial_port;

import kernel.port_manager.serial_port.SerialPort;
import org.jmock.Expectations;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Contains unit tests for {@link SerialPort#isPortOwned()}
 */
public class IsPortOwned extends SerialPortTestCase {
    @Test
    public void isPortOwnedTrue(){
        this.context.checking(new Expectations(){{
            oneOf(portIdentifier).isCurrentlyOwned();
            will(returnValue(true));
        }});

        assertTrue(this.portIdentifier.isCurrentlyOwned());
    }

    @Test
    public void isPortOwnedFalse(){
        this.context.checking(new Expectations(){{
            oneOf(portIdentifier).isCurrentlyOwned();
            will(returnValue(false));
        }});

        assertFalse(this.portIdentifier.isCurrentlyOwned());
    }
}
