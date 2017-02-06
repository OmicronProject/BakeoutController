package devices;

import kernel.serial_ports.PortConfiguration;
import kernel.serial_ports.RXTXPortConfiguration;
import kernel.views.DeviceListEntry;

/**
 * Implements a human-readable data structure containing a name for a
 * device, and the type to use for constructing the device.
 */
public class StandaloneDeviceListEntry implements DeviceListEntry {
    private final Class deviceType;
    private final String deviceName;

    public StandaloneDeviceListEntry(Class deviceType, String deviceName){
        this.deviceType = deviceType;
        this.deviceName = deviceName;
    }

    @Override public Class getDeviceType(){
        return deviceType;
    }

    @Override public String toString(){
        return deviceName;
    }

    @Override public PortConfiguration getDefaultConfiguration(){
        return new RXTXPortConfiguration(
                PortConfiguration.BAUD_RATE_9600,
                PortConfiguration.STOPBITS_1,
                PortConfiguration.DATABITS_8,
                PortConfiguration.PARITY_NONE
            );
    }

    @Override public Boolean requiresAddress(){
        return true;
    }
}
