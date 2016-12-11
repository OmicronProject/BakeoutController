package unit.devices.power_supply;

import exceptions.NotAllowedAddressException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link devices.PowerSupply#setAddress(int)}
 */
public class TestSetAddress extends TestPowerSupplyWithFixture {
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
