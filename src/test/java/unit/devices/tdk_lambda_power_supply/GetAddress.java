package unit.devices.tdk_lambda_power_supply;

import devices.TDKLambdaPowerSupply;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link TDKLambdaPowerSupply#getAddress()}
 */
public class GetAddress extends TestTDKLambdaPowerSupplyWithFixture {
    @Test public void getAddress(){
        assertEquals(desiredAddress, supply.getAddress());
    }
}
