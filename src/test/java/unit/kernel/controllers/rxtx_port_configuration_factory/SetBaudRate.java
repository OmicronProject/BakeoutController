package unit.kernel.controllers.rxtx_port_configuration_factory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for
 * {@link kernel.controllers.RXTXPortConfigurationFactory#setBaudRate(Integer)}
 */
public final class SetBaudRate extends RXTXPortConfigurationFactoryTestCase {

    @Test
    public void setBaudRate(){
        this.portConfigurationFactory.setBaudRate(baudRate);
        finishConstruction();

        assertEquals((int) baudRate, getBaudRateFromConfiguration());

    }

    private void finishConstruction(){
        this.portConfigurationFactory.setStopBits(stopBits);
        this.portConfigurationFactory.setDataBits(dataBits);
        this.portConfigurationFactory.setParityBits(parityBits);
    }

    private int getBaudRateFromConfiguration(){
        return this.portConfigurationFactory.getConfiguration().getBaudRate();
    }

}
