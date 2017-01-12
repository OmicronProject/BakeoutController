package unit.devices.tdk_lambda_power_supply;

import devices.PowerSupply;
import devices.TDKLambdaPowerSupply;
import org.junit.Before;
import unit.devices.DevicesTestCase;

import java.io.IOException;

/**
 * Base class for all tests of {@link devices.TDKLambdaPowerSupply}
 */
public abstract class TDKLambdaPowerSupplyTestCase extends DevicesTestCase {
    protected final String deviceName = "Mockup Power Supply - Unit testing";
    protected final int deviceAddress = 6;
    protected PowerSupply powerSupply;

    @Before
    public void setUpPowerSupply() throws IOException {
        this.communicatorForTestCase.write("OK");
        powerSupply = new TDKLambdaPowerSupply(deviceName, communicatorForDevice,
                deviceAddress);
    }
}
