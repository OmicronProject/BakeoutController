package devices;

import exceptions.NotAllowedAddressException;
import exceptions.NotAllowedBaudRateException;

import java.util.ArrayList;

/**
 * Describes all methods that the power supply implements
 */
interface PowerSupply {

    /**
     * 1200 bits per second Baud Rate
     */
    int BAUD_RATE_1200 = 1200;

    /**
     * 2400 bits per second Baud Rate
     */
    int BAUD_RATE_2400 = 2400;

    /**
     * 4800 bits per second Baud Rate
     */
    int BAUD_RATE_4800 = 4800;

    /**
     * 9600 bits per second Baud Rate
     */
    int BAUD_RATE_9600 = 9600;

    /**
     * 19200 bits per second Baud Rate
     */
    int BAUD_RATE_19200 = 19200;

    /**
     * Minimum RS232 Address for the Power Supply
     */
    int MINIMUM_ADDRESS = 0;

    /**
     * Maximum RS232 Address for the Power supply
     */
    int MAXIMUM_ADDRESS = 30;

    /**
     * The power supply's default address
     */
    int DEFAULT_ADDRESS = 6;

    /**
     * The default application Baud rate. This is controlled by a DIP switch
     * at the back of the power supply, so there really isn't a hard-coded
     * default rate. Set it to the fastest speed
     */
    int DEFAULT_BAUD_RATE = BAUD_RATE_19200;

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

    /**
     * @return The Data format of the RS232 Connection
     */
    int getDataFormat();

    /**
     * @return The parity regime of the RS232 Connection to this instrument
     */
    int getParity();

    /**
     * @return The address of the Power Supply
     */
    int getAddress();

    /**
     * @param newAdress The new address to set
     */
    void setAddress(int newAdress) throws NotAllowedAddressException;
}
