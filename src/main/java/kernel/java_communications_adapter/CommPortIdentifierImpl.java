package kernel.java_communications_adapter;

import gnu.io.PortInUseException;

/**
 * Provides a stub to {@link CommPort} so that it can be mocked for unit
 * testing
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
        gnu.io.CommPort portFromAPI = this.portIdentifier.open(appName,
                timeout);

        return new CommPortImpl(portFromAPI);
    }
}
