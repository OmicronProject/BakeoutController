package kernel.port_manager;

import java.util.ArrayList;
/**
 * Wraps static methods in the Java Communications API to allow stubbing
 */
public interface PortManager {

    /**
     * @return The names of all communication ports
     */
    ArrayList<String> getPortNames();

    /**
     * @return A list of serial ports available to the system
     */
    ArrayList<String> getSerialPortNames();
}
