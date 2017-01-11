package kernel.serial_ports;

/**
 * Data structure to hold configuration parameters for a given Serial Port
 */
public final class RXTXPortConfiguration implements PortConfiguration {
    private final int baudRate;
    private final int stopBits;
    private final int dataBits;
    private final int parityBits;

    public RXTXPortConfiguration(int baudRate, int stopBits, int dataBits,
                                 int parityBits){
        this.baudRate = baudRate;
        this.stopBits = stopBits;
        this.dataBits = dataBits;
        this.parityBits = parityBits;
    }

    /**
     * @return The desired Baud rate (bits per second)
     */
    @Override public int getBaudRate(){
        return this.baudRate;
    }

    /**
     * @return The number of stop bits
     */
    @Override public int getStopBits(){
        return this.stopBits;
    }

    /**
     * @return The number of data bits
     */
    @Override public int getDataBits(){
        return this.dataBits;
    }

    /**
     * @return The number of parity bits
     */
    @Override public int getParityBits(){
        return this.parityBits;
    }
}
