package unit.devices.power_supply;

import devices.PowerSupply;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link PowerSupply#getBaudRate() getBaudRate()}
 * method
 */
public class TestGetBaudRate extends TestPowerSupplyWithFixture {

    /**
     * Tests that the desired Baud rate is successfully returned by the getter.
     */
    @Test
    public void test_get_baud_rate(){
        int baud = supply.getBaudRate();

        assertEquals(PowerSupply.BAUD_RATE_1200, baud);
    }
}
