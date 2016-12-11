package unit.devices.power_supply;

import devices.PowerSupply;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Contains unit tests for {@link PowerSupply#getAllowedBaudRates()}
 */
public class TestGetAllowedBaudRates extends TestPowerSupplyWithFixture {
    private Integer[] expectedAllowedBaudRates;

    @Before public void makeAllowedBaudRates(){
        expectedAllowedBaudRates = new Integer[5];

        expectedAllowedBaudRates[0] = PowerSupply.BAUD_RATE_1200;
        expectedAllowedBaudRates[1] = PowerSupply.BAUD_RATE_2400;
        expectedAllowedBaudRates[2] = PowerSupply.BAUD_RATE_4800;
        expectedAllowedBaudRates[3] = PowerSupply.BAUD_RATE_9600;
        expectedAllowedBaudRates[4] = PowerSupply.BAUD_RATE_19200;
    }

    @Test
    public void getBaudRates(){
        assertArrayEquals(
            expectedAllowedBaudRates,
            supply.getAllowedBaudRates().toArray()
        );
    }
}
