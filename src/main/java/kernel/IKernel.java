package kernel;

import java.util.ArrayList;

/**
 * Describes available methods for the Kernel of this application
 */
public interface IKernel {
    /**
     * @return The name of all the available comm ports on the system
     */
    ArrayList<String> getCommPortNames();
}
