package kernel.comm_port_manager;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;

/**
 * Created by mkononen on 09/12/16.
 */
public class CommPortManager implements ICommPortManager {
    private Enumeration identifiers;

    public CommPortManager(){
        identifiers = CommPortIdentifier.getPortIdentifiers();

    }
    @Override public Enumeration<String> getCommPortNames(){
        return new CommPortList(identifiers);
    }
}

