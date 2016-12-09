package kernel;

import java.util.Enumeration;

/**
 * Describes available methods for the Kernel of this application
 */
public interface IKernel {
    /**
     * @return The name of all the available comm ports on the system
     */
    public Enumeration<String> getCommPortNames();
}
