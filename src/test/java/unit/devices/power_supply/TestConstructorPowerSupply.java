package unit.devices.power_supply;

import devices.PowerSupply;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Contains Unit tests for the Power Supply
 */
public class TestConstructorPowerSupply extends TestPowerSupply {

    /**
     * Tests that the default constructor creates a device with Baud rate
     * of 19200 bits per second by default
     */
    @Test public void testConstructor(){
        PowerSupply powersupply = new PowerSupply();
        assertNotNull(powersupply);
    }

    /**
     * Tests that there is also a constructor that accepts an integer baud
     * Rate.
     */
    @Test public void testConstructorWithChosenBaudandAddress(){
        PowerSupply powerSupply = new PowerSupply(
            desiredBaudRate, desiredAddress
        );
        assertNotNull(powerSupply);
    }
}
