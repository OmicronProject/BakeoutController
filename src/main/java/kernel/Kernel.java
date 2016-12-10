package kernel;

import java.util.ArrayList;
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
     * available on a given machine. This method queries all available port
     * names, and returns them in a list
     *
     * @return The available port names
     */
    public ArrayList<String> getCommPortNames() {
        Enumeration<String> namesFromManager =
                commPortManager.getCommPortNames();

        ArrayList<String> portNames = new ArrayList<String>();

        while(namesFromManager.hasMoreElements()){
            portNames.add(namesFromManager.nextElement());
        }

        return portNames;
    }
}


