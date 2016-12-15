package unit.kernel.kernel_factory;

import exceptions.UnableToSetParameterException;
import kernel.ApplicationKernelFactory;
import kernel.comm_port_manager.CommPortManager;
import org.junit.Test;
import unit.kernel.MockCommPortManager;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Contains methods for
 * {@link ApplicationKernelFactory#setCommPortManager(CommPortManager)}
 */
public class SetCommPortManager extends TestKernelFactory {
    private MockCommPortManager newManager;

    public SetCommPortManager(){
        ArrayList<String> portNames = new ArrayList<>();
        portNames.add("COM1");
        portNames.add("COM2");

        this.newManager = new MockCommPortManager(portNames);
    }

    /**
     * Tests that the port manager can be switched out for any manager that
     * implements {@link CommPortManager}
     */
    @Test public void testSetter(){
        applicationKernelFactory.setCommPortManager(newManager);

        assertEquals(
            newManager, applicationKernelFactory.getCommPortManager()
        );
    }

    /**
     * Tests that {@link UnableToSetParameterException} is thrown if the
     * manager tries to be set while running the kernel
     */
    @Test(expected= UnableToSetParameterException.class)
    public void testSetterWithError(){
        this.startKernel();
        applicationKernelFactory.setCommPortManager(commPortManager);
    }
}
