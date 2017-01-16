package unit.devices.tdk_lambda_power_supply;

import devices.TDKLambdaPowerSupply;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link TDKLambdaPowerSupply#getName()}
 */
public class GetName extends TDKLambdaPowerSupplyTestCase {

    @Test
    public void testGetName(){
        assertEquals(
            this.deviceName,
            this.powerSupply.getName()
        );
    }
}
