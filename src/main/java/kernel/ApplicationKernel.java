package kernel;

import kernel.comm_port_manager.PortManager;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Maintains all hardware interactions
 */
class ApplicationKernel implements Kernel {
    private final PortManager portManager;
    private final String applicationName;

    /**
     * Instantiate a new kernel
     * @param applicationName The name of the application. This will be used
     *                        in order to negotiate for RS 232 ports.
     * @param portManager The device to use to manage serial communication
     *                        ports in the application
     */
    ApplicationKernel(
        String applicationName, PortManager portManager
    ){
        this.portManager = portManager;
        this.applicationName = applicationName;
    }

    /**
     * Returns an enumeration of strings representing all the port names
     * available on a given machine. This method queries all available port
     * names, and returns them in a list
     *
     * @return The available port names
     */
    @Override public ArrayList<String> getCommPortNames() {
        Enumeration<String> namesFromManager =
                portManager.getCommPortNames();

        ArrayList<String> portNames = new ArrayList<String>();

        while(namesFromManager.hasMoreElements()){
            portNames.add(namesFromManager.nextElement());
        }

        return portNames;
    }

    /**
     * @return The name of the application
     */
    @Override public String getApplicationName(){
        return this.applicationName;
    }
}


