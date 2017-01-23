package kernel;

import kernel.controllers.VoltageController;
import kernel.views.VoltageReporter;

/**
 * Contains methods for working with application hardware, getting the
 * necessary views and controllers for working with the UI
 */
final class ApplicationKernel implements Kernel {
    private VoltageReporter voltageReporter;
    private VoltageController voltageController;

    public ApplicationKernel(
        VoltageReporter voltageReporter, VoltageController voltageController
    ){
        this.voltageReporter = voltageReporter;
        this.voltageController = voltageController;
    }

    @Override public VoltageController getVoltageController(){
        return this.voltageController;
    }

    @Override public VoltageReporter getVoltageReporter(){
        return this.voltageReporter;
    }
}
