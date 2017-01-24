package ui.debug_panel;

import exceptions.NoKernelException;
import kernel.Kernel;

/**
 * Describes a panel that contains a kernel
 */
public interface PanelWithKernel {
    /**
     * @param kernel The kernel to be set
     */
    void setKernel(Kernel kernel);

    /**
     * @return True if the application has a kernel
     */
    Boolean hasKernel();

    /**
     * Updates this component with parameters from the kernel
     * @throws NoKernelException if there is no kernel
     */
    void update() throws NoKernelException;
}
