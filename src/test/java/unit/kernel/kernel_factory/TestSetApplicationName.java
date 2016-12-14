package unit.kernel.kernel_factory;

import exceptions.UnableToSetParameterException;
import kernel.ApplicationKernelFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link ApplicationKernelFactory#setApplicationName(String)}
 */
public class TestSetApplicationName extends TestKernelFactory {
    private static final String newAppName = "newApp";

    @Test public void testVanillaSetter(){
        applicationKernelFactory.setApplicationName(newAppName);

        assertEquals(newAppName, applicationKernelFactory.getApplicationName());
    }

    @Test(expected = UnableToSetParameterException.class)
    public void testSetterWhenRunning(){
        this.startKernel();
        applicationKernelFactory.setApplicationName(newAppName);
    }
}
