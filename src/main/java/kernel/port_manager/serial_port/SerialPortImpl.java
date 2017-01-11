package kernel.port_manager.serial_port;

import gnu.io.UnsupportedCommOperationException;
import kernel.java_communications_adapter.CommPort;
import gnu.io.PortInUseException;
import kernel.java_communications_adapter.CommPortIdentifier;

/**
 * Implements methods for working with RS232 serial ports
 */
public class SerialPortImpl implements SerialPort {
    private final CommPortIdentifier portIdentifier;
    private final String ownerName;
    private final int timeout;

    private CommPort openPort;
    private boolean isPortOpen;

    public SerialPortImpl(CommPortIdentifier portIdentifier, String
            ownerName, int timeout){
        this.portIdentifier = portIdentifier;
        this.ownerName = ownerName;
        this.timeout = timeout;
        this.isPortOpen = false;
    }

    @Override public String getOwnerName(){
        return this.ownerName;
    }

    @Override public boolean isPortOwned(){
        return this.portIdentifier.isCurrentlyOwned();
    }

    @Override public void acquire() throws PortInUseException {
        this.openPort = this.portIdentifier.open(this.ownerName, this.timeout);
        this.isPortOpen = true;
    }

    @Override public void release(){
        this.openPort.close();
        this.isPortOpen = false;
    }

    @Override public boolean isPortOpen(){
        return this.isPortOpen;
    }

    @Override public PortConfigurationParameters getPortConfig(){
        kernel.java_communications_adapter.SerialPort port =
                castToSerialPort(this.openPort);

        return port.getConfig();
    }

    @Override public void setPortConfig(
            PortConfigurationParameters newParameters) throws
            UnsupportedCommOperationException {
        kernel.java_communications_adapter.SerialPort port =
                castToSerialPort(this.openPort);

        port.setConfig(newParameters);
    }

    private static kernel.java_communications_adapter.SerialPort
            castToSerialPort(
                    kernel.java_communications_adapter.CommPort port
    ){
        return (kernel.java_communications_adapter.SerialPort)(port);
    }
}
