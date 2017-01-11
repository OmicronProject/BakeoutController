package kernel.java_communications_adapter;

import gnu.io.UnsupportedCommOperationException;
import kernel.port_manager.serial_port.PortConfigurationParameters;

/**
 * Exposes methods from the Java Communications API for working with serial
 * ports
 */
public interface SerialPort extends CommPort {

    /**
     * @return The current port configuration
     */
    PortConfigurationParameters getConfig();

    /**
     * @param parameters The parameters to set the serial port to
     * @throws UnsupportedCommOperationException if the operation cannot be
     * done
     */
    void setConfig(PortConfigurationParameters parameters)
            throws UnsupportedCommOperationException;
}
