package unit.kernel.port_manager.port_manager;

import kernel.java_communications_adapter.JavaCommunicationsAPIAdapter;
import kernel.port_manager.PortManager;
import kernel.port_manager.PortManagerImpl;
import org.junit.Before;
import unit.kernel.port_manager.PortManagerModuleTestCase;

/**
 * Base class for all tests involving {@link kernel.port_manager}
 */
public abstract class PortManagerTestCase extends PortManagerModuleTestCase {
    /**
     * The instance of {@link PortManager} to be used for testing
     */
    protected PortManager portManager;

    /**
     * A stubbed-out {@link JavaCommunicationsAPIAdapter} to test the Java
     * Communications API
     */
    protected JavaCommunicationsAPIAdapter mockAdapter;

    /**
     * set up a mock adapter
     */
    @Before
    public void setUpMockAdapter(){
        this.mockAdapter = context.mock(JavaCommunicationsAPIAdapter.class);
    }

    /**
     * Set up the test fixture
     */
    @Before
    public void setUpPortManager(){
        this.portManager = new PortManagerImpl(this.mockAdapter);
    }
}
