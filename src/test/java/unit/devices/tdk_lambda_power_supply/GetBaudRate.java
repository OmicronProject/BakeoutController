package unit.devices.tdk_lambda_power_supply;

import devices.TDKLambdaPowerSupply;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link TDKLambdaPowerSupply#getBaudRate() getBaudRate()}
 * method
 */
public class GetBaudRate extends TestTDKLambdaPowerSupplyWithFixture {

    /**
     * Tests that the desired Baud rate is successfully returned by the getter.
     */
    @Test
    public void testGetBaudRate(){
        int baud = supply.getBaudRate();

        assertEquals(TDKLambdaPowerSupply.BAUD_RATE_1200, baud);
    }
}
