package unit.devices.tdk_lambda_power_supply;

import devices.TDKLambdaPowerSupply;
import exceptions.NotAllowedAddressException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link TDKLambdaPowerSupply#setAddress(int)}
 */
public class SetAddress extends TestTDKLambdaPowerSupplyWithFixture {
    private int goodAddress = 10;
    private int badAddress = 300;

    @Test public void testSetGoodAddress(){
        supply.setAddress(goodAddress);
        assertEquals(goodAddress, supply.getAddress());
    }

    @Test(expected=NotAllowedAddressException.class)
    public void testSetBadAddress(){
        supply.setAddress(badAddress);
    }
}
