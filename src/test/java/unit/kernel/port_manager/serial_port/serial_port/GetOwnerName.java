package unit.kernel.port_manager.serial_port.serial_port;

import kernel.port_manager.serial_port.SerialPort;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Base class for unit tests of
 * {@link SerialPort#getOwnerName()}
 */
public class GetOwnerName extends SerialPortTestCase {
    /**
     * Tests the code happy path
     */
    @Test
    public void getOwnerName(){
        assertEquals(this.ownerName, this.serialPort.getOwnerName());
    }
}
