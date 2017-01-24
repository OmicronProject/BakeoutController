package unit.kernel.application_kernel_bootstrapper;

import exceptions.UnableToCreateKernelException;
import kernel.ApplicationKernelBootstraper;
import kernel.Kernel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for
 * {@link ApplicationKernelBootstraper#getKernelInstance()}
 */
public final class GetKernelInstance extends
        ApplicationKernelBootstrapperTestCase {

    @Test(expected = UnableToCreateKernelException.class)
    public void unfinishedKernel(){
        this.applicationKernelBootstrapper.getKernelInstance();
    }

    @Test
    public void finishedKernel(){
        constructKernelFactory();
        Kernel kernel = this.applicationKernelBootstrapper.getKernelInstance();
        assertEquals(
            mockVoltageController,
            kernel.getVoltageController()
        );
    }

    private void constructKernelFactory(){
        applicationKernelBootstrapper.setPortDriver(mockPortDriver);
        applicationKernelBootstrapper.setVoltageController(mockVoltageController);
        applicationKernelBootstrapper.setVoltageReporter(mockVoltageReporter);
    }
}
