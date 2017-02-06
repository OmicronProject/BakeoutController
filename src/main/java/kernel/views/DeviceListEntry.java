package kernel.views;

import kernel.serial_ports.PortConfiguration;

/**
 * Created by mkononen on 02/02/17.
 */
public interface DeviceListEntry {
    Class getDeviceType();

    @Override String toString();

    PortConfiguration getDefaultConfiguration();

    Boolean requiresAddress();
}
