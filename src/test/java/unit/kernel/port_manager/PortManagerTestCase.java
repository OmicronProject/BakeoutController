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
    protected PortManager portManager;

    protected JavaCommunicationsAPIAdapter mockAdapter;

    protected Mockery context = new JUnit4Mockery(){{
        setThreadingPolicy(new Synchroniser());
    }};

    @Before
    public void setUpMockAdapter(){
        this.mockAdapter = context.mock(JavaCommunicationsAPIAdapter.class);
    }

    @Before
    public void setUpPortManager(){
        this.portManager = new PortManagerImpl(this.mockAdapter);
    }
}
