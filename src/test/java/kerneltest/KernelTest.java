package kerneltest;

import kernel.ICommPortManager;
import kernel.Kernel;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests that the kernel is successfully able to get names of ports
 */
@RunWith(JMock.class)
public class KernelTest {

    private Mockery context = new Mockery();

    @Test
    public void testGetPortNames(){
        ICommPortManager manager = context.mock(ICommPortManager.class);

        Kernel kernel = new Kernel(manager);

        context.checking(new Expectations() {{
            oneOf(manager).getCommPortNames();
        }});

        kernel.getCommPortNames();

        context.assertIsSatisfied();
    }
}
