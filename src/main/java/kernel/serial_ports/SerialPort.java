package kernel.serial_ports;

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
     * close the port and release it to the world
     */
    void close();

    PortConfiguration getConfig();

    void setConfig(PortConfiguration newConfig) throws
            UnsupportedCommOperationException ;
}
