package kernel.java_communications_adapter;

import gnu.io.UnsupportedCommOperationException;
import kernel.port_manager.serial_port.PortConfig;
import kernel.port_manager.serial_port.PortConfigurationParameters;

/**
 * Implements methods for working with Serial Ports
 */
public class SerialPortImpl extends CommPortImpl implements SerialPort {
    private final gnu.io.SerialPort serialPort;

    protected SerialPortImpl(gnu.io.CommPort commPort){
        super(commPort);
        this.serialPort = castToSerialPort(commPort);
    }

    /**
     * In order to make the best use of the RXTX library, and the Java
     * Communications API, the {@link gnu.io.CommPort} needs to be cast to a
     * {@link gnu.io.SerialPort}. This method does that.
     * @param commPort The port to cast
     * @return The port returned as a {@link gnu.io.SerialPort}
     */
    private static gnu.io.SerialPort castToSerialPort(
            gnu.io.CommPort commPort){
        return (gnu.io.SerialPort)(commPort);
    }

    @Override public PortConfigurationParameters getConfig(){
        String portName = this.serialPort.getName();
        int baudRate = this.serialPort.getBaudRate();
        int parityBits = this.serialPort.getParity();
        int stopBits = this.serialPort.getStopBits();
        int dataFormat = this.serialPort.getDataBits();

        return new PortConfig(
            portName, baudRate, dataFormat, stopBits, parityBits
        );
    }

    @Override public void setConfig(PortConfigurationParameters parameters)
            throws UnsupportedCommOperationException {
        this.serialPort.setSerialPortParams(
            parameters.getBaudRate(), parameters.getDataFormat(),
            parameters.getStopBits(), parameters.getParityBits()
        );
    }
}
