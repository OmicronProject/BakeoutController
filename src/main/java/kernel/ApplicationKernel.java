package kernel;

import kernel.controllers.VoltageController;
import kernel.serial_ports.PortDriver;
import kernel.views.CommPortReporter;
import kernel.views.VoltageReporter;

import java.util.List;

/**
 * Contains methods for working with application hardware, getting the
 * necessary views and controllers for working with the UI
 */
final class ApplicationKernel implements Kernel, CommPortReporter {
    private VoltageReporter voltageReporter;
    private VoltageController voltageController;
    private PortDriver portDriver;

    public ApplicationKernel(
        VoltageReporter voltageReporter, VoltageController voltageController,
        PortDriver portDriver
    ){
        this.voltageReporter = voltageReporter;
        this.voltageController = voltageController;
        this.portDriver = portDriver;
    }

    @Override public VoltageController getVoltageController(){
        return this.voltageController;
    }

    @Override public VoltageReporter getVoltageReporter(){
        return this.voltageReporter;
    }

    @Override public CommPortReporter getCommPortReporter(){
        return this;
    }

    @Override public List<String> getSerialPortNames(){
        return this.portDriver.getSerialPortNames();
    }
}
