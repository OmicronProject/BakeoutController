package kernel.java_communications_adapter;

import gnu.io.UnsupportedCommOperationException;
import kernel.port_manager.serial_port.PortConfigurationParameters;

/**
 * Exposes methods from the Java Communications API for working with serial
 * ports
 */
public interface SerialPort extends CommPort {
    PortConfigurationParameters getConfig();
    void setConfig(PortConfigurationParameters parameters)
            throws UnsupportedCommOperationException;
}
