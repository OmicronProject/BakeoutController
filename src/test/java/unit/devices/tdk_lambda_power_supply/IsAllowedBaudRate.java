package unit.devices.tdk_lambda_power_supply;

import devices.PowerSupply;
import devices.TDKLambdaPowerSupply;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Contains unit tests for {@link TDKLambdaPowerSupply#isAllowedBaudRate(int)}
 */
public class IsAllowedBaudRate extends TestTDKLambdaPowerSupplyWithFixture {
    /**
     * Tests that the method returns True for an allowed Baud Rate
     */
    @Test public void testIsAllowedBaudRateTrue(){
        assertTrue(supply.isAllowedBaudRate(PowerSupply.BAUD_RATE_1200));
    }

    /**
     * Tests that the method returns False for a bad Baud rate
     */
    @Test public void testIsAllowedBaudRateFalse(){
        int badBaudRate = 0;
        assertFalse(supply.isAllowedBaudRate(badBaudRate));
    }
}
