package kernel.port_manager.serial_port;

import gnu.io.PortInUseException;

/**
 * Exposes methods required for working with RS232 serial ports
 */
public interface SerialPort {
    /**
     * @return The name under which the port will be acquired
     */
    String getOwnerName();

    boolean isPortOwned();

    void acquire() throws PortInUseException;

    void release();

    boolean isPortOpen();
}
