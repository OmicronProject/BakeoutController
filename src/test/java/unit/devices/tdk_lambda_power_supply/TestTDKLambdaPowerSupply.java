package unit.devices.tdk_lambda_power_supply;

import devices.TDKLambdaPowerSupply;
import org.junit.Before;

/**
 * Base class for all tests of {@link TDKLambdaPowerSupply TDKLambdaPowerSupply} that do
 * not test {@link TDKLambdaPowerSupply TDKLambdaPowerSupply}'s constructor.
 */
class TestTDKLambdaPowerSupply {
    int desiredBaudRate;
    int desiredAddress;

    /**
     * Initialize a basic test for the Power Supply
     */
    @Before public void setUp(){
        desiredBaudRate = TDKLambdaPowerSupply.BAUD_RATE_1200;
        desiredAddress = 6;
    }
}
