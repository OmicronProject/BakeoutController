package unit.kernel.port_manager;

import kernel.port_manager.PortManager;
import org.jmock.Expectations;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

/**
 * Contains unit tests for {@link PortManager#getSerialPortNames()}
 */
public class GetSerialPortNames extends PortManagerTestCase {
    @Test
    public void getSerialPortNames(){
        this.context.checking(new Expectations(){{
            oneOf(mockAdapter).getCommPortIdentifiers();
        }});

        ArrayList<String> portNames = this.portManager.getSerialPortNames();

        assertNotNull(portNames);
    }
}
