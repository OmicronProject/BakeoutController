package kernel.comm_port_manager;

import java.util.Enumeration;

/**
 * Wraps static methods in the Java Communications API to allow stubbing
 */
public interface CommPortManager {

    /**
     * @return The names of all communication ports
     */
    Enumeration<String> getCommPortNames();
}
