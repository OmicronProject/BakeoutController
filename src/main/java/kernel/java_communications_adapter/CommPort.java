package kernel.java_communications_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Wraps {@link gnu.io.CommPort} in an interface
 */
public interface CommPort {
    /**
     * closes the port and makes it free to other applications
     */
    void close();

    /**
     * @return The stream for writing to the port
     * @throws IOException if the {@link InputStream} cannot be retrieved
     */
    InputStream getInputStream() throws IOException;

    /**
     * @return The stream for reading from the port
     * @throws IOException if the {@link OutputStream} cannot be retrieved
     */
    OutputStream getOutputStream() throws IOException;
}
