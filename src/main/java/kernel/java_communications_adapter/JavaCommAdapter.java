package kernel.java_communications_adapter;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;

import java.util.Enumeration;

/**
 * Wraps the port identifier method
 */
public class JavaCommAdapter implements JavaCommunicationsAPIAdapter {
    public JavaCommAdapter(){}

    /**
     * @return The identifiers available to the system
     */
    @Override public Enumeration getCommPortIdentifiers(){
        return CommPortIdentifier.getPortIdentifiers();
    }

    /**
     * @param portName the name of the port to retrieve
     * @return the identifier for the port
     * @throws NoSuchPortException if the port does not exist
     */
    @Override public CommPortIdentifier getCommPortIdentifier(String portName)
            throws NoSuchPortException {
        return CommPortIdentifier.getPortIdentifier(portName);
    }
}
