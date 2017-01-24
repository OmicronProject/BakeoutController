package unit.kernel.application_kernel_bootstrapper;

import kernel.serial_ports.PortDriver;
import org.junit.Test;

/**
 * Contains unit tests for
 * {@link kernel.ApplicationKernelBootstraper#setPortDriver(PortDriver)}
 */
public final class SetPortDriver extends
        ApplicationKernelBootstrapperTestCase {
    @Test
    public void setPortDriverUnfinished(){
        this.applicationKernelBootstrapper.setPortDriver(mockPortDriver);
        assertKernelConstructionFails();
    }
}
