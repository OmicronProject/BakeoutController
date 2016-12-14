package kernel;

import kernel.comm_port_manager.CommPortManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Maintains all hardware interactions
 */
public class ApplicationKernel implements Kernel {
    private final CommPortManager commPortManager;
    private final String applicationName;
    private final Logger logger;

    /**
     * Instantiate a new kernel
     *
     * @param commPortManager The device to use to manage serial communication
     *                        ports in the application
     */
    public ApplicationKernel(String applicationName, CommPortManager commPortManager){
        this.commPortManager = commPortManager;
        this.applicationName = applicationName;
        this.logger = setUpLogger();
    }

    /**
     * Set up a logging tool to log data
     */
    private static Logger setUpLogger(){
        Logger logger = LoggerFactory.getLogger(ApplicationKernel.class);
        logger.info("Started application");

        return logger;
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
                commPortManager.getCommPortNames();

        ArrayList<String> portNames = new ArrayList<String>();

        while(namesFromManager.hasMoreElements()){
            portNames.add(namesFromManager.nextElement());
        }

        return portNames;
    }
}


