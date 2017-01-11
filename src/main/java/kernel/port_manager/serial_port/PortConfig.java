package kernel.port_manager.serial_port;

/**
 * Provides a simple data structure to get port configuration parameters
 */
public class PortConfig implements PortConfigurationParameters {
    private final String portName;
    private final int baudRate;
    private final int dataFormat;
    private final int stopBits;
    private final int parityBits;

    public PortConfig(
            String portName, int baudRate, int dataFormat,
            int stopBits, int parityBits
    ){
        this.portName = portName;
        this.baudRate = baudRate;
        this.dataFormat = dataFormat;
        this.stopBits = stopBits;
        this.parityBits = parityBits;
    }

    @Override public String getPortName(){
        return this.portName;
    }

    @Override public int getBaudRate(){
        return this.baudRate;
    }

    @Override public int getDataFormat(){
        return this.dataFormat;
    }

    @Override public int getStopBits(){
        return this.stopBits;
    }

    @Override public int getParityBits(){
        return this.parityBits;
    }
}
