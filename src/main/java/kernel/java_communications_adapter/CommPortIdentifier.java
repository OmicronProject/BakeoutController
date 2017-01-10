package kernel.java_communications_adapter;

import gnu.io.CommPort;
import gnu.io.PortInUseException;

/**
 * Created by mkononen on 10/01/17.
 */
public interface CommPortIdentifier {
    boolean isCurrentlyOwned();

    CommPort open(String appName, int timeout) throws PortInUseException;
}
