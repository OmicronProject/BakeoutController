package unit.devices.power_supply;

import devices.PowerSupply;
import gnu.io.SerialPort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link PowerSupply#getParity()}
 */
public class TestGetParity extends TestPowerSupplyWithFixture {
    @Test public void testGetParity(){
        assertEquals(SerialPort.PARITY_NONE, supply.getParity());
    }
}
