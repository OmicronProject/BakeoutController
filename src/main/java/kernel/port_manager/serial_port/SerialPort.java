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

    /**
     * @return True if the port is owned, otherwise False
     */
    boolean isPortOwned();

    /**
     * opens the serial port
     *
     * @throws PortInUseException if the port is being used by another
     * application
     */
    void acquire() throws PortInUseException;

    /**
     * closes the serial port
     */
    void release();

    /**
     * @return True if the port has been acquired, otherwise False
     */
    boolean isPortOpen();
}
