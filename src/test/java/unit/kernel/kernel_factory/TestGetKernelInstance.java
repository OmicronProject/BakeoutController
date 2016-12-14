package unit.kernel.kernel_factory;

import exceptions.UnableToCreateKernelException;
import kernel.Kernel;
import kernel.KernelFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link KernelFactory#getKernelInstance()}
 */
public class TestGetKernelInstance extends TestKernelFactory {
    private final KernelFactory blankKernelFactory;
    private final KernelFactory kernelFactoryWithName;
    private final KernelFactory kernelFactoryWithManager;

    public TestGetKernelInstance(){
        super();

        blankKernelFactory = new KernelFactory();
        kernelFactoryWithName = new KernelFactory();
        kernelFactoryWithManager = new KernelFactory();

        setUpKernelFactoryWithName();
        setUpKernelFactoryWithManager();
    }

    private void setUpKernelFactoryWithName(){
        kernelFactoryWithName.setApplicationName(applicationName);
    }

    private void setUpKernelFactoryWithManager(){
        kernelFactoryWithManager.setCommPortManager(commPortManager);
    }

    @Test public void testWhetherKernelIsSingleton(){
        Kernel kernel = kernelFactory.getKernelInstance();
        Kernel secondKernel = kernelFactory.getKernelInstance();

        assertEquals(kernel, secondKernel);
    }

    @Test(expected = UnableToCreateKernelException.class)
    public void testKernelWithOnlyName(){
        kernelFactoryWithName.getKernelInstance();
    }

    @Test(expected = UnableToCreateKernelException.class)
    public void testKernelWithOnlyManager(){
        kernelFactoryWithManager.getKernelInstance();
    }

    @Test(expected = UnableToCreateKernelException.class)
    public void testBlankKernel(){
        blankKernelFactory.getKernelInstance();
    }
}
