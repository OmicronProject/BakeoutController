package kernel;

import exceptions.UnableToCreateKernelException;
import kernel.controllers.VoltageController;
import kernel.serial_ports.PortDriver;
import kernel.views.VoltageReporter;

/**
 * Describes methods for a bean to bootstrap the application kernel
 */
public interface KernelFactory {
    void setPortDriver(PortDriver newPortDriver);

    Kernel getKernelInstance() throws UnableToCreateKernelException;

    Boolean canKernelBeStarted();
}
