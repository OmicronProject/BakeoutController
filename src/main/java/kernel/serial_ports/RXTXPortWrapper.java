package kernel.serial_ports;

import gnu.io.RXTXPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Wraps the RXTX port
 */
public class RXTXPortWrapper implements SerialPort, PortCommunicator,
        PortConfiguration {
    private final RXTXPort port;

    public RXTXPortWrapper(RXTXPort portToWrap){
        this.port = portToWrap;
    }

    @Override public PortCommunicator getCommunicator(){
        return this;
    }

    @Override public InputStream getInputStream(){
        return this.port.getInputStream();
    }

    @Override public OutputStream getOutputStream(){
        return this.port.getOutputStream();
    }

    @Override public PortConfiguration getConfig(){
        return this;
    }

    @Override public int getBaudRate(){
        return this.port.getBaudRate();
    }

    @Override public int getStopBits(){
        return this.port.getStopBits();
    }

    @Override public int getDataBits(){
        return this.port.getDataBits();
    }

    @Override public int getParityBits(){
        return this.port.getParity();
    }

    @Override public void setConfig(PortConfiguration newConfig) throws
            UnsupportedCommOperationException {
        this.port.setSerialPortParams(
            newConfig.getBaudRate(), newConfig.getDataBits(),
            newConfig.getStopBits(), newConfig.getParityBits()
        );
    }

    @Override public void close(){
        this.port.close();
    }
}
