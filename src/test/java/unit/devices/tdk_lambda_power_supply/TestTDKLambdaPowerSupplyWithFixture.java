package unit.devices.tdk_lambda_power_supply;

import devices.PowerSupply;
import devices.TDKLambdaPowerSupply;
import org.junit.Before;

/**
 * Base class for all unit tests of {@link TDKLambdaPowerSupply } that require
 * instantiation of {@link TDKLambdaPowerSupply}
 */
class TestTDKLambdaPowerSupplyWithFixture extends TestTDKLambdaPowerSupply {
    protected PowerSupply supply;
    protected int desiredBaudRate;
    protected int desiredAddress;

    /**
     * Creates the fixture
     */
    @Before public void setUp(){
        desiredBaudRate = PowerSupply.BAUD_RATE_1200;
        desiredAddress = 5;
        supply = new TDKLambdaPowerSupply(desiredBaudRate, desiredAddress);
    }
}
