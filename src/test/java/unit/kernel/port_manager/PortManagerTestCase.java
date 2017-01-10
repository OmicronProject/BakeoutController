package unit.kernel.port_manager;

import kernel.java_communications_adapter.JavaCommunicationsAPIAdapter;
import kernel.port_manager.PortManager;
import kernel.port_manager.PortManagerImpl;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Before;
import unit.kernel.KernelTestCase;

/**
 * Base class for all tests involving {@link kernel.port_manager}
 */
public abstract class PortManagerTestCase extends KernelTestCase {
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
     * The JMock context for mocking out interfaces
     */
    protected Mockery context = new JUnit4Mockery(){{
        setThreadingPolicy(new Synchroniser());
    }};

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
