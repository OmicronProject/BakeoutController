package unit.kernel.kernel_factory;

import kernel.KernelFactory;
import kernel.comm_port_manager.ICommPortManager;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;

/**
 * Contains unit tests for {@link kernel.KernelFactory}
 */
public class TestKernelFactory {
    final String applicationName;
    final ICommPortManager commPortManager;
    final KernelFactory kernelFactory;

    @Rule public JUnitRuleMockery context = new JUnitRuleMockery();

    public TestKernelFactory(){
        commPortManager = context.mock(ICommPortManager.class);
        applicationName = "Unit Testing BakeoutController";
        kernelFactory = new KernelFactory();

        setUpKernelFactory();
    }

    private void setUpKernelFactory(){
        kernelFactory.setApplicationName(applicationName);
    }
}
