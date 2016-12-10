package unit.devices.power_supply;

import devices.PowerSupply;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Contains Unit tests for the Power Supply
 */
public class PowerSupplyConstructorTest {
    private int desiredBaudRate = PowerSupply.BAUD_RATE_1200;

    @Test
    public void testConstructor(){
        PowerSupply powersupply = new PowerSupply();

        assertNotNull(powersupply);
    }

    @Test
    public void testConstructorWithChosenBaud(){
        PowerSupply powerSupply = new PowerSupply(desiredBaudRate);
        assertNotNull(powerSupply);
    }
}
