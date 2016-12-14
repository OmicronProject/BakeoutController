package unit.devices.tdk_lambda_power_supply;

import devices.TDKLambdaPowerSupply;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Contains unit tests for {@link TDKLambdaPowerSupply#getAllowedBaudRates()}
 */
public class GetAllowedBaudRates extends TestTDKLambdaPowerSupplyWithFixture {
    private Integer[] expectedAllowedBaudRates;

    /**
     * Set up a list of allowed Baud Rates
     */
    @Before public void makeAllowedBaudRates(){
        expectedAllowedBaudRates = new Integer[5];

        expectedAllowedBaudRates[0] = TDKLambdaPowerSupply.BAUD_RATE_1200;
        expectedAllowedBaudRates[1] = TDKLambdaPowerSupply.BAUD_RATE_2400;
        expectedAllowedBaudRates[2] = TDKLambdaPowerSupply.BAUD_RATE_4800;
        expectedAllowedBaudRates[3] = TDKLambdaPowerSupply.BAUD_RATE_9600;
        expectedAllowedBaudRates[4] = TDKLambdaPowerSupply.BAUD_RATE_19200;
    }

    /**
     * Tests that the list of allowed Baud rates matches the one set up in
     * the pervious test
     */
    @Test public void getBaudRates(){
        assertArrayEquals(
            expectedAllowedBaudRates,
            supply.getAllowedBaudRates().toArray()
        );
    }
}
