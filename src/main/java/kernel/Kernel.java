package kernel;

import java.util.ArrayList;

/**
 * Describes available methods for the ApplicationKernel of this application
 */
interface Kernel {
    /**
     * @return The name of all the available comm ports on the system
     */
    ArrayList<String> getCommPortNames();

    /**
     * @return The name of the application
     */
    String getApplicationName();
}
