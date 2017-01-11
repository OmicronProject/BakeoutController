package kernel.serial_ports;

import gnu.io.RXTXPort;

/**
 * Describes methods required for setting port parameters
 * If the constants are to be used, please ensure that they're specified in
 * this interface. The last thing I want is some magic numbers floating
 * around.
 *
 * @apiNote For multiple devices, the address is not set here. That will be
 * set later on the device.
 */
public interface PortConfiguration {
    /**
     * @return The Baud rate for the port
     */
    int getBaudRate();

    /**
     * @return The number of data bits for the port
     */
    int getDataBits();

    /**
     * @return The number of parity bits in the port
     */
    int getParityBits();

    /**
     * @return The number of stop bits in the port
     */
    int getStopBits();

    int DATABITS_8 = RXTXPort.DATABITS_8;

    int BAUD_RATE_9600 = 9600;

    int PARITY_NONE = RXTXPort.PARITY_NONE;

    int STOPBITS_1 = RXTXPort.STOPBITS_1;

}
