package unit.kernel.serial_ports;

import kernel.serial_ports.comm_port_wrapper.CommPortWrapper;
import org.junit.Before;
import unit.kernel.KernelTestCase;

/**
 * Base class for unit tests of {@link kernel.serial_ports}
 */
public abstract class SerialPortsTestCase extends KernelTestCase {
    protected CommPortWrapper mockJavaCommAPI;

    @Before
    public void setUpMockJavaCommunicationsAPI(){
        this.mockJavaCommAPI = this.context.mock(CommPortWrapper.class);
    }
}
