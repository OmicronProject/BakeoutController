package unit.kernel.port_manager;

import kernel.port_manager.PortManager;
import org.jmock.Expectations;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

/**
 * Contains unit tests for {@link PortManager#getPortNames()}
 */
public class GetPortNames extends PortManagerTestCase {
    /**
     * Walks through the code's happy path
     */
    @Test
    public void getPortNames(){
        this.context.checking(new Expectations(){{
            oneOf(mockAdapter).getCommPortIdentifiers();
        }});

        ArrayList<String> portNames = this.portManager.getPortNames();

        assertNotNull(portNames);
    }
}
