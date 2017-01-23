package kernel;

import kernel.controllers.VoltageController;
import kernel.views.VoltageReporter;

/**
 * Describes the main application kernel
 */
public interface Kernel {
    VoltageController getVoltageController();
    VoltageReporter getVoltageReporter();
}
