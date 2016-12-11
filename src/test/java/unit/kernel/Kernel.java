package unit.kernel;

import kernel.comm_port_manager.ICommPortManager;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests that the kernel is successfully able to get names of ports
 */
@RunWith(JMock.class)
public class Kernel {

    private Mockery context = new Mockery();

    @Test
    public void testGetPortNames(){
        ICommPortManager manager = context.mock(ICommPortManager.class);

        kernel.Kernel kernel = new kernel.Kernel(manager);

        context.checking(new Expectations() {{
            oneOf(manager).getCommPortNames();
        }});

        kernel.getCommPortNames();

        context.assertIsSatisfied();
    }
}
