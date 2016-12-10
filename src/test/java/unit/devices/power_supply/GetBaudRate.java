package unit.devices.power_supply;

import devices.PowerSupply;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by mkononen on 10/12/16.
 */
public class GetBaudRate {
    @Test
    public void test_get_baud_rate(){
        PowerSupply supply = new PowerSupply(PowerSupply.BAUD_RATE_1200);

        int baud = supply.getBaudRate();

        assertEquals(PowerSupply.BAUD_RATE_1200, baud);
    }
}
