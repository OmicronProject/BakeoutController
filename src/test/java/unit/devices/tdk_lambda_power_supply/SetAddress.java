package unit.devices.tdk_lambda_power_supply;

import devices.TDKLambdaPowerSupply;
import exceptions.NotAllowedAddressException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link TDKLambdaPowerSupply#setAddress(int)}
 */
public class SetAddress extends TestTDKLambdaPowerSupplyWithFixture {
    private static final int goodAddress = 10;
    private static final int badAddressTooHigh = 300;
    private static final int badAddressTooLow = -10;

    @Test public void testSetGoodAddress(){
        supply.setAddress(goodAddress);
        assertEquals(goodAddress, supply.getAddress());
    }

    @Test(expected = NotAllowedAddressException.class)
    public void testSetHighAddress(){ supply.setAddress(badAddressTooHigh); }

    @Test(expected = NotAllowedAddressException.class)
    public void testSetLowAddress() { supply.setAddress(badAddressTooLow); }
}
