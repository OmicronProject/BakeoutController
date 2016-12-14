package unit.kernel.kernel_factory;

import exceptions.UnableToSetParameterException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link kernel.KernelFactory#setApplicationName(String)}
 */
public class TestSetApplicationName extends TestKernelFactory {
    private static final String newAppName = "newApp";

    @Test public void testVanillaSetter(){
        kernelFactory.setApplicationName(newAppName);

        assertEquals(newAppName, kernelFactory.getApplicationName());
    }

    @Test(expected = UnableToSetParameterException.class)
    public void testSetterWhenRunning(){
        this.startKernel();
        kernelFactory.setApplicationName(newAppName);
    }
}
