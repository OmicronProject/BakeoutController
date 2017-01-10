package kernel.java_communications_adapter;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;

import java.util.Enumeration;

/**
 * Contains an adapter for the Java Communications API
 */
public interface JavaCommunicationsAPIAdapter {
    /**
     * Wraps {@link CommPortIdentifier#getPortIdentifiers()}
     * @return an {@link Enumeration} of port identifiers
     */
    Enumeration getCommPortIdentifiers();

    /**
     * Wraps {@link CommPortIdentifier#getPortIdentifier(String)}
     * @param portName the name of the port to retrieve
     * @return the required port Identifier
     * @throws NoSuchPortException if the port does not exist
     */
    CommPortIdentifier getCommPortIdentifier(String portName) throws
            NoSuchPortException;
}
