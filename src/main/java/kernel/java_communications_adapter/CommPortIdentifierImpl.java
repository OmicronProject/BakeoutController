package kernel.java_communications_adapter;

import gnu.io.CommPort;
import gnu.io.PortInUseException;

/**
 * Created by mkononen on 10/01/17.
 */
public class CommPortIdentifierImpl implements CommPortIdentifier {
    private gnu.io.CommPortIdentifier portIdentifier;

    public CommPortIdentifierImpl(gnu.io.CommPortIdentifier portIdentifier){
        this.portIdentifier = portIdentifier;
    }

    @Override public boolean isCurrentlyOwned(){
        return this.portIdentifier.isCurrentlyOwned();
    }

    @Override public CommPort open(String appName, int timeout) throws
            PortInUseException {
        return this.portIdentifier.open(appName, timeout);
    }
}
