package kernel.java_communications_adapter;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;

import java.util.Enumeration;

/**
 * Wraps the port identifier method
 */
public class JavaCommAdapter implements JavaCommunicationsAPIAdapter {
    public JavaCommAdapter(){};

    @Override public Enumeration getCommPortIdentifiers(){
        return CommPortIdentifier.getPortIdentifiers();
    }

    @Override public CommPortIdentifier getCommPortIdentifier(String portName)
            throws NoSuchPortException {
        return CommPortIdentifier.getPortIdentifier(portName);
    }
}
