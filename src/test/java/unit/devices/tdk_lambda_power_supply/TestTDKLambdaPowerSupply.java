package unit.devices.tdk_lambda_power_supply;

import devices.PowerSupply;
import devices.TDKLambdaPowerSupply;

/**
 * Base class for all tests of {@link TDKLambdaPowerSupply TDKLambdaPowerSupply} that do
 * not test {@link TDKLambdaPowerSupply TDKLambdaPowerSupply}'s constructor.
 */
class TestTDKLambdaPowerSupply {
    /**
     * Set up a default Baud Rate to which values will be changed
     */
    protected static final int desiredBaudRate = PowerSupply.BAUD_RATE_1200;

    /**
     * Set up a desired address to which values will be changed
     */
    protected static final int desiredAddress = 6;
}
