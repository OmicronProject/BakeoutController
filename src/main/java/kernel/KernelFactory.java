package kernel;

import exceptions.UnableToCreateKernelException;
import kernel.controllers.VoltageController;
import kernel.views.VoltageReporter;

/**
 * Describes methods for a bean to bootstrap the application kernel
 */
public interface KernelFactory {
    void setVoltageReporter(VoltageReporter newVoltageReporter);

    void setVoltageController(VoltageController newVoltageController);

    Kernel getKernelInstance() throws UnableToCreateKernelException;

    Boolean canKernelBeStarted();
}
