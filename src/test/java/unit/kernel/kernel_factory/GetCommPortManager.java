package unit.kernel.kernel_factory;

import kernel.ApplicationKernelFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains tests for {@link ApplicationKernelFactory#getPortManager()}
 */
public class GetCommPortManager extends TestKernelFactory {
    @Test public void getCommPortManager(){
        assertEquals(
                portManager, applicationKernelFactory.getPortManager()
        );
    }
}
