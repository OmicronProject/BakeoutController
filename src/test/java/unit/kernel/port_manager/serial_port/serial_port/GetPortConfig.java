package unit.kernel.port_manager.serial_port.serial_port;

import gnu.io.PortInUseException;
import kernel.port_manager.serial_port.PortConfigurationParameters;
import kernel.port_manager.serial_port.SerialPort;
import kernel.port_manager.serial_port.SerialPortImpl;
import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Contains unit tests for {@link SerialPort#getPortConfig()}
 */
public class GetPortConfig extends SerialPortTestCase {
    private kernel.java_communications_adapter.SerialPort mockSerialPort;

    @Before
    public void setUpMockSerialPort(){
        this.mockSerialPort = this.context.mock(
                kernel.java_communications_adapter.SerialPort.class);
    }

    @Before
    public void openPort() throws PortInUseException {
        this.context.checking(new Expectations(){{
            oneOf(portIdentifier).open(ownerName, timeout);
        }});
        this.serialPort.acquire();
    }

    /**
     * Tests the happy path of the code
     */
    @Test public void testHappyPath() throws PortInUseException {
        this.context.checking(new Expectations(){{
            oneOf(portIdentifier).open(ownerName, timeout);
            oneOf(mockSerialPort).getConfig();
        }});

        PortConfigurationParameters params = this.serialPort.getPortConfig();
        assertNotNull(params);
    }
}
