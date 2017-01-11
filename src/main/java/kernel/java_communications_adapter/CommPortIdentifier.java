package kernel.java_communications_adapter;

import gnu.io.PortInUseException;

/**
 * Wraps methods used in {@link gnu.io.CommPortIdentifier}, in order to
 * allow these methods to be stubbed out.
 */
public interface CommPortIdentifier {
    /**
     * @return True if the port is owned, otherwise False
     */
    boolean isCurrentlyOwned();

    /**
     * Open the port
     * @param appName The name under which the port will be signed out
     * @param timeout The amount of time in milliseconds to block the
     *                program and wait for port ownership. If the port is
     *                not received by the end of the timeout, an exception
     *                will be thrown
     * @return The open port
     * @throws PortInUseException if the port is not opened by the end of
     * the timeout
     */
    CommPort open(String appName, int timeout) throws PortInUseException;
}
