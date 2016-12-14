package unit.kernel.kernel_factory;

import kernel.KernelFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the method {@link KernelFactory#getApplicationName()}
 */
public class TestGetApplicationName extends TestKernelFactory {

    @Before public void setAppNameforSetup(){
        kernelFactory.setApplicationName(applicationName);
    }

    @Test public void getApplicationName(){
        assertEquals(this.applicationName, kernelFactory.getApplicationName());
    }
}
