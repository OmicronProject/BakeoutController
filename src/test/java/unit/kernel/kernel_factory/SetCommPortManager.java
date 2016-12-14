package unit.kernel.kernel_factory;

import exceptions.UnableToSetParameterException;
import kernel.comm_port_manager.ICommPortManager;
import org.junit.Test;

/**
 * Contains methods for
 * {@link kernel.KernelFactory#setCommPortManager(ICommPortManager)}
 */
public class SetCommPortManager extends TestKernelFactory {
    @Test public void testSetter(){
        kernelFactory.setCommPortManager(commPortManager);
    }

    @Test(expected= UnableToSetParameterException.class)
    public void testSetterWithError(){
        this.startKernel();
        kernelFactory.setCommPortManager(commPortManager);
    }
}
