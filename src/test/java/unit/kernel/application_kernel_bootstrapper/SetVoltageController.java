package unit.kernel.application_kernel_bootstrapper;

import kernel.controllers.VoltageController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for
 * {@link kernel.ApplicationKernelBootstraper#setVoltageController(VoltageController)}
 */
public final class SetVoltageController extends
        ApplicationKernelBootstrapperTestCase {
    @Test
    public void setVoltageControllerUnfinishedBuilding(){
        this.applicationKernelBootstrapper.setVoltageController(
                mockVoltageController
        );
        assertKernelConstructionFails();
    }

    @Test
    public void setVoltageControllerFinishedBuilding(){
        this.applicationKernelBootstrapper.setVoltageController(
                mockVoltageController
        );
        finishConstruction();
        assertEquals(
            mockVoltageController,
            this.applicationKernelBootstrapper.getKernelInstance().
                    getVoltageController()
        );
    }

    private void finishConstruction(){
        this.applicationKernelBootstrapper.setVoltageReporter
                (mockVoltageReporter);
        this.applicationKernelBootstrapper.setPortDriver(mockPortDriver);
    }
}
