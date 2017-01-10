package unit.kernel.kernel_factory;

import kernel.ApplicationKernelFactory;
import kernel.KernelFactory;
import kernel.comm_port_manager.PortManager;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;

/**
 * Contains unit tests for {@link ApplicationKernelFactory}
 */
public class TestKernelFactory {
    protected final String applicationName;
    protected final PortManager portManager;
    protected final KernelFactory applicationKernelFactory;

    @Rule public JUnitRuleMockery context = new JUnitRuleMockery();

    public TestKernelFactory(){
        portManager = context.mock(PortManager.class);
        applicationName = "Unit Testing BakeoutController";
        applicationKernelFactory = new ApplicationKernelFactory();

        setUpKernelFactory();
    }

    private void setUpKernelFactory(){
        applicationKernelFactory.setApplicationName(applicationName);
        applicationKernelFactory.setPortManager(portManager);
    }

    /**
     * Start the kernel, no way to stop except starting another test case
     */
    protected void startKernel(){
        applicationKernelFactory.getKernelInstance();
    }
}
