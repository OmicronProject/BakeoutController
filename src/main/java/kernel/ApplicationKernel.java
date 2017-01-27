package kernel;

import kernel.serial_ports.PortDriver;
import kernel.views.CommPortReporter;

import java.util.List;

/**
 * Contains methods for working with application hardware, getting the
 * necessary views and controllers for working with the UI
 */
final class ApplicationKernel implements Kernel, CommPortReporter {
    private PortDriver portDriver;

    public ApplicationKernel(PortDriver portDriver){
        this.portDriver = portDriver;
    }

    @Override public CommPortReporter getCommPortReporter(){
        return this;
    }

    @Override public List<String> getSerialPortNames(){
        return this.portDriver.getSerialPortNames();
    }
}
