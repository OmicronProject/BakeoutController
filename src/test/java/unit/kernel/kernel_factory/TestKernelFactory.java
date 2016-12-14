package unit.kernel.kernel_factory;

import kernel.ApplicationKernelFactory;
import kernel.KernelFactory;
import kernel.comm_port_manager.CommPortManager;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;

/**
 * Contains unit tests for {@link ApplicationKernelFactory}
 */
public class TestKernelFactory {
    final String applicationName;
    final CommPortManager commPortManager;
    final KernelFactory applicationKernelFactory;

    @Rule public JUnitRuleMockery context = new JUnitRuleMockery();

    public TestKernelFactory(){
        commPortManager = context.mock(CommPortManager.class);
        applicationName = "Unit Testing BakeoutController";
        applicationKernelFactory = new ApplicationKernelFactory();

        setUpKernelFactory();
    }

    private void setUpKernelFactory(){
        applicationKernelFactory.setApplicationName(applicationName);
        applicationKernelFactory.setCommPortManager(commPortManager);
    }

    /**
     * Start the kernel, no way to stop except starting another test case
     */
    void startKernel(){
        applicationKernelFactory.getKernelInstance();
    }
}
