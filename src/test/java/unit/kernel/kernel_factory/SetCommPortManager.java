package unit.kernel.kernel_factory;

import exceptions.UnableToSetParameterException;
import kernel.ApplicationKernelFactory;
import kernel.comm_port_manager.PortManager;
import org.junit.Test;
import unit.kernel.MockPortManager;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Contains methods for
 * {@link ApplicationKernelFactory#setPortManager(PortManager)}
 */
public class SetCommPortManager extends TestKernelFactory {
    private MockPortManager newManager;

    public SetCommPortManager(){
        ArrayList<String> portNames = new ArrayList<>();
        portNames.add("COM1");
        portNames.add("COM2");

        this.newManager = new MockPortManager(portNames);
    }

    /**
     * Tests that the port manager can be switched out for any manager that
     * implements {@link PortManager}
     */
    @Test public void testSetter(){
        applicationKernelFactory.setPortManager(newManager);

        assertEquals(
            newManager, applicationKernelFactory.getPortManager()
        );
    }

    /**
     * Tests that {@link UnableToSetParameterException} is thrown if the
     * manager tries to be set while running the kernel
     */
    @Test(expected= UnableToSetParameterException.class)
    public void testSetterWithError(){
        this.startKernel();
        applicationKernelFactory.setPortManager(portManager);
    }
}
