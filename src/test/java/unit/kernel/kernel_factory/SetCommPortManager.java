package unit.kernel.kernel_factory;

import exceptions.UnableToSetParameterException;
import kernel.ApplicationKernelFactory;
import kernel.comm_port_manager.CommPortManager;
import org.junit.Test;

/**
 * Contains methods for
 * {@link ApplicationKernelFactory#setCommPortManager(CommPortManager)}
 */
public class SetCommPortManager extends TestKernelFactory {
    @Test public void testSetter(){
        applicationKernelFactory.setCommPortManager(commPortManager);
    }

    @Test(expected= UnableToSetParameterException.class)
    public void testSetterWithError(){
        this.startKernel();
        applicationKernelFactory.setCommPortManager(commPortManager);
    }
}
