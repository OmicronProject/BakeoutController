package devices;

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
}
