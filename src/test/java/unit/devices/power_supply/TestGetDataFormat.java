package unit.devices.power_supply;

import devices.PowerSupply;
import gnu.io.SerialPort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link PowerSupply#getDataFormat()}
 */
public class TestGetDataFormat extends TestPowerSupplyWithFixture {
    @Test public void testGetDataFormat(){
        assertEquals(SerialPort.DATABITS_8, supply.getDataFormat());
    }
}
