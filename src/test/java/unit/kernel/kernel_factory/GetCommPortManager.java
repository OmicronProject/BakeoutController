package unit.kernel.kernel_factory;

import kernel.KernelFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains tests for {@link KernelFactory#getCommPortManager()}
 */
public class GetCommPortManager extends TestKernelFactory {
    @Test public void getCommPortManager(){
        assertEquals(
            commPortManager, kernelFactory.getCommPortManager()
        );
    }
}
