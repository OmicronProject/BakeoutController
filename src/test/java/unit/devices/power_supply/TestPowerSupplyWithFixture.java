package unit.devices.power_supply;

import devices.PowerSupply;
import org.junit.Before;

/**
 * Base class for all unit tests of {@link devices.PowerSupply } that require
 * instantiation of {@link devices.PowerSupply}
 */
class TestPowerSupplyWithFixture extends TestPowerSupply {
    PowerSupply supply;
    int desiredBaudRate;
    int desiredAddress;

    /**
     * Creates the fixture
     */
    @Before public void setUp(){
        desiredBaudRate = PowerSupply.BAUD_RATE_1200;
        desiredAddress = 5;
        supply = new PowerSupply(desiredBaudRate, desiredAddress);
    }
}
