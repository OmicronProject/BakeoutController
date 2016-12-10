package devices;

import exceptions.NotAllowedBaudRateException;

import java.util.ArrayList;

/**
 * Represents the TDK-Lambda Programmable Power Supply
 */
public class PowerSupply implements IPowerSupply {
    private int baudRate;

    /**
     * 1200 bits per second Baud Rate
     */
    public static final int BAUD_RATE_1200 = 1200;

    /**
     * 2400 bits per second Baud Rate
     */
    public static final int BAUD_RATE_2400 = 2400;

    /**
     * 4800 bits per second Baud Rate
     */
    public static final int BAUD_RATE_4800 = 4800;

    /**
     * 9600 bits per second Baud Rate
     */
    public static final int BAUD_RATE_9600 = 9600;

    /**
     * 19200 bits per second Baud Rate
     */
    public static final int BAUD_RATE_19200 = 19200;

    /**
     * @param desiredBaudRate The Baud Rate (bits per second) to be used in
     *                 communicating
     */
    public PowerSupply(int desiredBaudRate){

        this.setBaudRate(desiredBaudRate);
    }

    /**
     * If no Baud Rate is provided, then it is set to 19200 by default
     */
    public PowerSupply(){
        this(BAUD_RATE_19200);
    }

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
    public ArrayList<Integer> getAllowedBaudRates(){
        return makeBaudRateList();
    }

    /**
     * @return the current Baud Rate
     */
    public int getBaudRate(){return baudRate;}

    /**
     * @param baudRate The Baud rate to check
     * @return True if the Baud rate is allowed, otherwise False
     */
    public boolean isAllowedBaudRate(int baudRate){
        return this.makeBaudRateList().contains(baudRate);
    }

    /**
     * @param newBaudRate The new baud rate to be set
     * @throws NotAllowedBaudRateException if the Baud rate is not allowed
     */
    public void setBaudRate(int newBaudRate) throws
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
}
