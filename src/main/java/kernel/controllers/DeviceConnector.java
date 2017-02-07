package kernel.controllers;

import kernel.views.DeviceListEntry;

/**
 * Factory for creating connections to devices
 */
public interface DeviceConnector {
    DeviceListEntry getDeviceToConnect();
    void setDeviceToConnect(DeviceListEntry device);
    String getPortName();
    void setPortName(String portName);
    DeviceRegistry getDeviceRegistry();
    void setDeviceRegistry(DeviceRegistry registry);
    Boolean canMakeConnections();

    void connect();
}
