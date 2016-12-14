package kernel;

import kernel.comm_port_manager.ICommPortManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Maintains all hardware interactions
 */
public class Kernel implements IKernel {
    private ICommPortManager commPortManager;
    private String applicationName;
    private Logger logger;

    /**
     * Instantiate a new kernel
     *
     * @param commPortManager The device to use to manage serial communication
     *                        ports in the application
     */
    public Kernel(String applicationName, ICommPortManager commPortManager){
        this.commPortManager = commPortManager;
        this.applicationName = applicationName;
        setUpLogger();
    }

    /**
     * Set up a logging tool to log data
     */
    private void setUpLogger(){
        Logger logger = LoggerFactory.getLogger(Kernel.class);
        logger.info("Started application");

        this.logger = logger;
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


