package unit.kernel.application_kernel_bootstrapper;

import kernel.views.VoltageReporter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for
 * {@link kernel.ApplicationKernelBootstraper#setVoltageReporter(VoltageReporter)}
 */
public final class SetVoltageReporter extends
        ApplicationKernelBootstrapperTestCase {

    @Test
    public void setVoltageReporterNotFinishedBuilding(){
        this.applicationKernelBootstrapper.setVoltageReporter
                (mockVoltageReporter);

        assertKernelConstructionFails();
    }

    @Test
    public void setVoltageReporterFinishedBuilding(){
        this.applicationKernelBootstrapper.setVoltageReporter(
                mockVoltageReporter
        );

        finishConstruction();

        assertEquals(
            mockVoltageReporter,
            this.applicationKernelBootstrapper.getKernelInstance().
                    getVoltageReporter()
        );
    }

    private void finishConstruction(){
        this.applicationKernelBootstrapper.setPortDriver(
                mockPortDriver
        );
        this.applicationKernelBootstrapper.setVoltageController(
                mockVoltageController
        );
    }
}
