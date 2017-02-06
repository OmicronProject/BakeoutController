package unit.kernel.controllers.rxtx_port_configuration_factory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains unit tests for
 * {@link kernel.controllers.RXTXPortConfigurationFactory#setDataBits(Integer)}
 */
public final class SetDataBits extends RXTXPortConfigurationFactoryTestCase {
    @Test
    public void setDataBits(){
        this.portConfigurationFactory.setDataBits(dataBits);
        finishConstruction();

        assertEquals(
                (int) dataBits,
                this.portConfigurationFactory.getConfiguration().getDataBits()
        );
    }

    private void finishConstruction(){
        this.portConfigurationFactory.setBaudRate(baudRate);
        this.portConfigurationFactory.setStopBits(stopBits);
        this.portConfigurationFactory.setParityBits(parityBits);
    }
}
