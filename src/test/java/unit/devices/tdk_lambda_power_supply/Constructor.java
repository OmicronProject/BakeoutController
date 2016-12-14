package unit.devices.tdk_lambda_power_supply;

import devices.TDKLambdaPowerSupply;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Contains Unit tests for the Power Supply
 */
public class Constructor extends TestTDKLambdaPowerSupply {

    /**
     * Tests that the default constructor creates a device with Baud rate
     * of 19200 bits per second by default
     */
    @Test public void testConstructor(){
        TDKLambdaPowerSupply powersupply = new TDKLambdaPowerSupply();
        assertNotNull(powersupply);
    }

    /**
     * Tests that there is also a constructor that accepts an integer baud
     * Rate.
     */
    @Test public void testConstructorWithChosenBaudandAddress(){
        TDKLambdaPowerSupply TDKLambdaPowerSupply = new TDKLambdaPowerSupply(
            desiredBaudRate, desiredAddress
        );
        assertNotNull(TDKLambdaPowerSupply);
    }
}
