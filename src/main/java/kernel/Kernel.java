package kernel;

import java.util.Enumeration;

/**
 * Maintains all hardware interactions
 */
public class Kernel implements IKernel {
    private ICommPortManager commPortManager;

    /**
     * Instantiate a new kernel
     *
     * @param commPortManager The device to use to manage serial communication
     *                        ports in the application
     */
    public Kernel(ICommPortManager commPortManager){
        this.commPortManager = commPortManager;
    }

    /**
     * Returns an enumeration of strings representing all the port names
     * available on a given machine
     *
     * @return The available port names
     */
    public Enumeration<String> getCommPortNames() {
        return commPortManager.getCommPortNames();
    }
}


