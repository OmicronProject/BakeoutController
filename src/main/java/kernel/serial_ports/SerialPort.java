package kernel.serial_ports;

import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

/**
 * Describes what a serial port can do
 */
public interface SerialPort {

    /**
     * @return The stream wrapper used to obtain the input and output
     * streams for the pot
     */
    PortCommunicator getCommunicator();

    /**
     * Open the port
     */
    void open() throws PortInUseException;

    /**
     * close the port and release it to the world
     */
    void close();

    /**
     * @return true if the port is open, else false
     */
    boolean isPortOpen();

    PortConfiguration getConfig();

    void setConfig(PortConfiguration newConfig) throws
            UnsupportedCommOperationException ;
}
