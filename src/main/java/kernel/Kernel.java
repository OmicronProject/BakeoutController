package kernel;

import kernel.controllers.RS232PortConfigurationFactory;
import kernel.views.CommPortReporter;
import kernel.views.DeviceReporter;

/**
 * Describes the main application kernel
 */
public interface Kernel {
    /**
     * @return A view that can list the available serial ports on this machine
     */
    CommPortReporter getCommPortReporter();

    /**
     * @return A view that lists the available devices that can be implemented
     */
    DeviceReporter getDeviceReporter();

    RS232PortConfigurationFactory getRS232PortConfigurationFactory();
}
