package unit.devices.power_supply;

import devices.PowerSupply;
import org.junit.Before;

/**
 * Base class for all tests of {@link devices.PowerSupply PowerSupply} that do
 * not test {@link devices.PowerSupply PowerSupply}'s constructor.
 */
class TestPowerSupply {
    int desiredBaudRate;

    /**
     * Initialize a basic test for the Power Supply
     */
    @Before public void setUp(){
        desiredBaudRate = PowerSupply.BAUD_RATE_1200;
    }
}
