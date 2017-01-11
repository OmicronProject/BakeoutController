package unit.kernel.serial_ports.rxtx_port_driver;

import kernel.serial_ports.RXTXPortDriver;
import org.jmock.Expectations;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Contains unit tests for {@link RXTXPortDriver#getSerialPortNames()}
 */
public final class GetSerialPortNames extends RXTXPortDriverTestCase {
    @Test
    public void getSerialPortNames(){
        context.checking(new Expectations(){{
            oneOf(mockJavaCommAPI).getPortIdentifiers();
        }});

        assertNotNull(portDriver.getSerialPortNames());
    }
}
