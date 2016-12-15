package devices;

import exceptions.NotAllowedAddressException;
import exceptions.NotAllowedBaudRateException;
import gnu.io.SerialPort;

import java.util.ArrayList;

/**
 * Represents the TDK-Lambda Programmable Power Supply
 */
public class TDKLambdaPowerSupply implements PowerSupply {
    private int baudRate;
    private int address;

    /**
     * @param desiredBaudRate The Baud Rate (bits per second) to be used in
     *                 communicating
     */
    public TDKLambdaPowerSupply(int desiredBaudRate, int desiredAddress){

        this.setBaudRate(desiredBaudRate);
        this.setAddress(desiredAddress);
    }

    /**
     * If no Baud Rate is provided, then it is set to 19200 by default
     */
    public TDKLambdaPowerSupply(){this(DEFAULT_BAUD_RATE, DEFAULT_ADDRESS);}

    /**
     * Compress all baud rates into a single list
     * @return A list of all allowed Baud rates
     */
    private ArrayList<Integer> makeBaudRateList(){
        ArrayList<Integer> baudRates = new ArrayList<>();

        baudRates.add(BAUD_RATE_1200);
        baudRates.add(BAUD_RATE_2400);
        baudRates.add(BAUD_RATE_4800);
        baudRates.add(BAUD_RATE_9600);
        baudRates.add(BAUD_RATE_19200);

        return baudRates;
    }

    /**
     * @return the allowed Baud Rates
     */
    @Override public ArrayList<Integer> getAllowedBaudRates(){
        return makeBaudRateList();
    }

    /**
     * @return the current Baud Rate
     */
    @Override public int getBaudRate(){return baudRate;}

    /**
     * @param baudRate The Baud rate to check
     * @return True if the Baud rate is allowed, otherwise False
     */
    @Override public boolean isAllowedBaudRate(int baudRate){
        return this.makeBaudRateList().contains(baudRate);
    }

    /**
     * @param newBaudRate The new baud rate to be set
     * @throws NotAllowedBaudRateException if the Baud rate is not allowed
     */
    @Override public void setBaudRate(int newBaudRate) throws
            NotAllowedBaudRateException {
        if (!this.isAllowedBaudRate(newBaudRate)){
            String messageToThrow = String.format(
                    "Attempted to set a power supply Baud Rate of %d. This " +
                            "is not allowed.", newBaudRate
            );
            throw new NotAllowedBaudRateException(messageToThrow);
        }

        this.baudRate = newBaudRate;
    }

    /**
     * @return The required data format
     */
    @Override public int getDataFormat(){ return SerialPort.DATABITS_8; }

    /**
     * @return The parity regime of the Power supply connection
     */
    @Override public int getParity(){
        return SerialPort.PARITY_NONE;
    }

    /**
     * @return The current address of the Power Supply
     */
    @Override public int getAddress(){ return address; }

    /**
     * Set the device address to a new Address
     * @param newAddress The address to which the device is to be set
     * @throws NotAllowedAddressException if the address is not allowed
     */
    @Override public void setAddress(int newAddress) throws
            NotAllowedAddressException {
        if(newAddress < MINIMUM_ADDRESS || newAddress > MAXIMUM_ADDRESS){
            String messageToThrow = String.format(
                "Attempted to set address of %d which is not between %d and " +
                        "%d",
                newAddress, MINIMUM_ADDRESS, MAXIMUM_ADDRESS
            );

            throw new NotAllowedAddressException(messageToThrow);
        }

        this.address = newAddress;
    }
}
