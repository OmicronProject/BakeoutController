package unit.kernel.port_manager.serial_port.serial_port;

import kernel.java_communications_adapter.CommPort;
import kernel.java_communications_adapter.CommPortIdentifier;
import kernel.port_manager.serial_port.SerialPort;
import kernel.port_manager.serial_port.SerialPortImpl;
import org.junit.Before;
import unit.kernel.port_manager.serial_port.SerialPortModuleTestCase;

/**
 * Base class for unit tests involving
 * {@link kernel.port_manager.serial_port.SerialPort}
 */
public abstract class SerialPortTestCase extends SerialPortModuleTestCase {
    protected CommPortIdentifier portIdentifier;

    protected final String ownerName = "Unit Testing";
    protected final int timeout = 1000;

    protected SerialPort serialPort;
    protected CommPort commPort;

    @Before public void setUpMockPortIdentifier(){
        this.portIdentifier = context.mock(CommPortIdentifier.class);
    }

    @Before public void setUpMockCommPort(){
        this.commPort = context.mock(CommPort.class);
    }

    @Before public void setUpSerialPort(){
        this.serialPort = new SerialPortImpl(
            this.portIdentifier, this.ownerName, this.timeout);
    }
}
