package unit.devices.power_supply;

import devices.PowerSupply;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link PowerSupply#getAddress()}
 */
public class TestGetAddress extends TestPowerSupplyWithFixture {
    @Test public void getAddress(){
        assertEquals(desiredAddress, supply.getAddress());
    }
}
