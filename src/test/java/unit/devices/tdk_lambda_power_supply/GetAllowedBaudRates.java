package unit.devices.tdk_lambda_power_supply;

import devices.PowerSupply;
import devices.TDKLambdaPowerSupply;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link TDKLambdaPowerSupply#getAllowedBaudRates()}
 */
public class GetAllowedBaudRates extends TestTDKLambdaPowerSupplyWithFixture {
    private ArrayList<Integer> expectedAllowedBaudRates;

    /**
     * Set up a list of allowed Baud Rates
     */
    @Before public void makeAllowedBaudRates(){
        expectedAllowedBaudRates = new ArrayList<>();

        expectedAllowedBaudRates.add(PowerSupply.BAUD_RATE_1200);
        expectedAllowedBaudRates.add(PowerSupply.BAUD_RATE_2400);
        expectedAllowedBaudRates.add(PowerSupply.BAUD_RATE_4800);
        expectedAllowedBaudRates.add(PowerSupply.BAUD_RATE_9600);
        expectedAllowedBaudRates.add(PowerSupply.BAUD_RATE_19200);
    }

    /**
     * Tests that the list of allowed Baud rates matches the one set up in
     * the pervious test
     */
    @Test public void getBaudRates(){
        assertEquals(
            expectedAllowedBaudRates,
            supply.getAllowedBaudRates()
        );
    }
}
