package kernel.java_communications_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Wraps {@link gnu.io.CommPort} in an interface
 */
public interface CommPort {
    void close();

    InputStream getInputStream() throws IOException;

    OutputStream getOutputStream() throws IOException;

    String getName();
}
