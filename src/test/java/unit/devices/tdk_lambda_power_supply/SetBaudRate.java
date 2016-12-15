package unit.devices.tdk_lambda_power_supply;

import devices.PowerSupply;
import devices.TDKLambdaPowerSupply;
import exceptions.NotAllowedBaudRateException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link TDKLambdaPowerSupply#setBaudRate(int)}
 */
public class SetBaudRate extends TestTDKLambdaPowerSupplyWithFixture {
    private int badBaudRate = 0;

    /**
     * Tests that a Baud Rate can be set successfully
     */
    @Test public void testSetGoodBaudRates(){
        supply.setBaudRate(PowerSupply.BAUD_RATE_19200);
        assertEquals(PowerSupply.BAUD_RATE_19200, supply.getBaudRate());

        supply.setBaudRate(PowerSupply.BAUD_RATE_1200);
        assertEquals(PowerSupply.BAUD_RATE_1200, supply.getBaudRate());
    }

    /**
     * Tests that {@link NotAllowedBaudRateException} is thrown if a bad Baud
     * rate is passed into the supply
     */
    @Test(expected=NotAllowedBaudRateException.class)
    public void testSetBadBaudRate(){
        supply.setBaudRate(badBaudRate);
    }
}
