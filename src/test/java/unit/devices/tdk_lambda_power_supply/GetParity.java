package unit.devices.tdk_lambda_power_supply;

import devices.TDKLambdaPowerSupply;
import gnu.io.SerialPort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link TDKLambdaPowerSupply#getParity()}
 */
public class GetParity extends TestTDKLambdaPowerSupplyWithFixture {
    @Test public void testGetParity(){
        assertEquals(SerialPort.PARITY_NONE, supply.getParity());
    }
}
