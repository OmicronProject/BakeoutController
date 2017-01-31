package kernel;

import kernel.serial_ports.PortDriver;
import kernel.views.CommPortReporter;

import java.util.List;

/**
 * Contains methods for working with application hardware, getting the
 * necessary views and controllers for working with the UI
 */
final class ApplicationKernel implements Kernel, CommPortReporter {

    /**
     * The driver responsible for managing serial ports
     */
    private PortDriver portDriver;

    /**
     * @param portDriver The driver to be used for managing the RS232 serial
     *                   port
     */
    public ApplicationKernel(PortDriver portDriver){
        this.portDriver = portDriver;
    }

    /**
     * @return An implementation of {@link CommPortReporter} that can report
     * serial port names
     */
    @Override public CommPortReporter getCommPortReporter(){
        return this;
    }

    /**
     * @return The names of serial ports available on this machine
     */
    @Override public List<String> getSerialPortNames(){
        return this.portDriver.getSerialPortNames();
    }
}
