package unit.kernel;

import kernel.ApplicationKernelFactory;
import kernel.KernelFactory;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests that the kernel is successfully able to get names of ports
 */
public class Kernel {
    private static final String appName = "app";
    private kernel.Kernel appKernel;
    private MockCommPortManager portManager;

    @Rule public JUnitRuleMockery context = new JUnitRuleMockery();

    /**
     * Bootstrap an application kernel so that its interface can be tested
     */
    @Before
    public void setUpKernel(){
        portManager = new MockCommPortManager();
        KernelFactory factory = new ApplicationKernelFactory();

        factory.setApplicationName(appName);
        factory.setCommPortManager(portManager);

        appKernel = factory.getKernelInstance();
    }

    /**
     * Tests {@link kernel.Kernel#getCommPortNames()}
     */
    @Test
    public void testGetPortNames(){
        assertEquals(portManager.getPortNames(), appKernel.getCommPortNames()
        );
    }
}
