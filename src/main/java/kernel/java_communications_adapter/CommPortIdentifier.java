package kernel.java_communications_adapter;

import gnu.io.PortInUseException;

/**
 * Wraps methods used in {@link gnu.io.CommPortIdentifier}, in order to
 * allow these methods to be stubbed out.
 */
public interface CommPortIdentifier {
    boolean isCurrentlyOwned();

    CommPort open(String appName, int timeout) throws PortInUseException;
}
