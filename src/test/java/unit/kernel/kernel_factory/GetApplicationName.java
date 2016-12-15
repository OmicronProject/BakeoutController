package unit.kernel.kernel_factory;

import kernel.ApplicationKernelFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the method {@link ApplicationKernelFactory#getApplicationName()}
 */
public class GetApplicationName extends TestKernelFactory {

    @Before public void setAppNameforSetup(){
        applicationKernelFactory.setApplicationName(applicationName);
    }

    @Test public void getApplicationName(){
        assertEquals(this.applicationName, applicationKernelFactory.getApplicationName());
    }
}
