package unit.devices.tdk_lambda_power_supply;

import devices.TDKLambdaPowerSupply;
import gnu.io.SerialPort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for {@link TDKLambdaPowerSupply#getDataFormat()}
 */
public class GetDataFormat extends TestTDKLambdaPowerSupplyWithFixture {
    @Test public void testGetDataFormat(){
        assertEquals(SerialPort.DATABITS_8, supply.getDataFormat());
    }
}
