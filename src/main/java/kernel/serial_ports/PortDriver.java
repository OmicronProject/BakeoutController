package kernel.serial_ports;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;

import java.util.List;

/**
 * Gets the name of all serial ports on the system
 */
public interface PortDriver {
    /**
     * @return The name of serial ports available to this machine
     */
    List<String> getSerialPortNames();

    /**
     * @return The name to use when signing out serial ports
     */
    String getApplicationName();

    /**
     * @param portName The name of the port that needs to be retrieved. An
     *                 example of a valid name is "/dev/ttyUSB0"
     * @return An open serial port
     * @throws NoSuchPortException if no port with that name is available to
     * the application
     * @throws PortInUseException if the port exists, but is currently owned
     * by another application.
     */
    SerialPort getPortByName(String portName) throws NoSuchPortException,
            PortInUseException;
}
