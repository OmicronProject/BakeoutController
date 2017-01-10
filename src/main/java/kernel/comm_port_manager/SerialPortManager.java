package kernel.comm_port_manager;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;

/**
 * Manages all RS232 connections
 */
public class SerialPortManager implements PortManager {
    /**
     * The comm port identifiers returned by the API
     */
    private Enumeration identifiers;

    /**
     * Construct the port manager, and query for port identifiers
     */
    public SerialPortManager(){
        identifiers = CommPortIdentifier.getPortIdentifiers();

    }

    /**
     * @return An enumeration of COM port names
     */
    @Override public Enumeration<String> getCommPortNames(){
        return new CommPortList(identifiers);
    }
}

