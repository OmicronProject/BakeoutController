package unit.kernel.kernel_factory;

import exceptions.UnableToCreateKernelException;
import kernel.ApplicationKernel;
import kernel.ApplicationKernelFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link ApplicationKernelFactory#getKernelInstance()}
 */
public class GetKernelInstance extends TestKernelFactory {
    private final ApplicationKernelFactory blankApplicationKernelFactory;
    private final ApplicationKernelFactory applicationKernelFactoryWithName;
    private final ApplicationKernelFactory applicationKernelFactoryWithManager;

    public GetKernelInstance(){
        super();

        blankApplicationKernelFactory = new ApplicationKernelFactory();
        applicationKernelFactoryWithName = new ApplicationKernelFactory();
        applicationKernelFactoryWithManager = new ApplicationKernelFactory();

        setUpKernelFactoryWithName();
        setUpKernelFactoryWithManager();
    }

    private void setUpKernelFactoryWithName(){
        applicationKernelFactoryWithName.setApplicationName(applicationName);
    }

    private void setUpKernelFactoryWithManager(){
        applicationKernelFactoryWithManager.setCommPortManager(commPortManager);
    }

    @Test public void testWhetherKernelIsSingleton(){
        ApplicationKernel applicationKernel = applicationKernelFactory.getKernelInstance();
        ApplicationKernel secondApplicationKernel = applicationKernelFactory.getKernelInstance();

        assertEquals(applicationKernel, secondApplicationKernel);
    }

    @Test(expected = UnableToCreateKernelException.class)
    public void testKernelWithOnlyName(){
        applicationKernelFactoryWithName.getKernelInstance();
    }

    @Test(expected = UnableToCreateKernelException.class)
    public void testKernelWithOnlyManager(){
        applicationKernelFactoryWithManager.getKernelInstance();
    }

    @Test(expected = UnableToCreateKernelException.class)
    public void testBlankKernel(){
        blankApplicationKernelFactory.getKernelInstance();
    }
}
