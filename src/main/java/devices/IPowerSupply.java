package devices;

import exceptions.NotAllowedBaudRateException;

import java.util.ArrayList;

/**
 * Describes all methods that the power supply implements
 */
interface IPowerSupply {

    /**
     * @return The current baud rate of the device
     */
    int getBaudRate();

    /**
     * @return The allowed baud rates (bits per second) that the device
     * supports.
     */
    ArrayList<Integer> getAllowedBaudRates();

    /**
     * Checks whether a Baud rate is allowed by the device
     * @param baudRate The Baud rate to check
     * @return True if the baud rate is allowed, otherwise False
     */
    boolean isAllowedBaudRate(int baudRate);

    /**
     * @param newBaudRate The new baud rate to be set
     * @throws NotAllowedBaudRateException if the Baud rate to be set is not
     *  a valid Baud rate
     */
    void setBaudRate(int newBaudRate) throws NotAllowedBaudRateException;
}
