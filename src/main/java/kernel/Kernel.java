package kernel;

import kernel.views.CommPortReporter;

/**
 * Describes the main application kernel
 */
public interface Kernel {
    CommPortReporter getCommPortReporter();
}
