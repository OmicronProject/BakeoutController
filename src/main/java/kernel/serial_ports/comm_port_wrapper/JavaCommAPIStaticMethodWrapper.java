package kernel.serial_ports.comm_port_wrapper;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;

import java.util.Enumeration;

/**
 * Created by mkononen on 11/01/17.
 */
public class JavaCommAPIStaticMethodWrapper implements CommPortWrapper {
    public JavaCommAPIStaticMethodWrapper(){}

    @Override public Enumeration getPortIdentifiers(){
        return CommPortIdentifier.getPortIdentifiers();
    }
}
