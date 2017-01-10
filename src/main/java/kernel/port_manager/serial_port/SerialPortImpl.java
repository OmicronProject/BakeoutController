package kernel.port_manager.serial_port;

import gnu.io.CommPortIdentifier;

/**
 * Created by mkononen on 10/01/17.
 */
public class SerialPortImpl implements SerialPort {
    private final CommPortIdentifier portIdentifier;

    public SerialPortImpl(CommPortIdentifier portIdentifier) {
        this.portIdentifier = portIdentifier;
    }
}
