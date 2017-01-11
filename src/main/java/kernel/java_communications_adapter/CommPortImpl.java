package kernel.java_communications_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Wraps {@link gnu.io.CommPort} using the {@link CommPort} interface.
 */
public class CommPortImpl implements CommPort {
    private final gnu.io.CommPort commPort;

    /**
     * Set up the stub commPort
     * @param commPort The commPort as returned by the Java Communications API
     */
    protected CommPortImpl(gnu.io.CommPort commPort){
        this.commPort = commPort;
    }

    /**
     * Close the connection
     */
    @Override public void close(){
        this.commPort.close();
    }

    @Override public InputStream getInputStream() throws IOException {
        return this.commPort.getInputStream();
    }

    @Override public OutputStream getOutputStream() throws IOException {
        return this.commPort.getOutputStream();
    }
}
