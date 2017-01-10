package kernel.java_communications_adapter;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;

/**
 * Wraps the port identifier method
 */
public class JavaCommAdapter implements JavaCommunicationsAPIAdapter {
    public JavaCommAdapter(){};

    public Enumeration getCommPortIdentifiers(){
        return CommPortIdentifier.getPortIdentifiers();
    }
}
