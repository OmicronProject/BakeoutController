package unit.kernel.kernel_factory;

import kernel.ApplicationKernelFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains tests for {@link ApplicationKernelFactory#getCommPortManager()}
 */
public class GetCommPortManager extends TestKernelFactory {
    @Test public void getCommPortManager(){
        assertEquals(
            commPortManager, applicationKernelFactory.getCommPortManager()
        );
    }
}
