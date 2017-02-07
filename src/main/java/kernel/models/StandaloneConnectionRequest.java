package kernel.models;

import kernel.views.ConnectionRequest;
import kernel.views.DeviceListEntry;

/**
 * Created by mkononen on 07/02/17.
 */
public class StandaloneConnectionRequest implements ConnectionRequest {
    private DeviceListEntry deviceListEntry;
    private Integer address;
    private String portName;

    public StandaloneConnectionRequest(
        DeviceListEntry deviceListEntry, Integer address, String portName
    ){
        this.deviceListEntry = deviceListEntry;
        this.address = address;
        this.portName = portName;
    }

    @Override public DeviceListEntry getDeviceListEntry(){
            return deviceListEntry;
    }

    @Override public Integer getAddress(){
        return this.address;
    }

    @Override public String getPortName(){
        return this.portName;
    }
}
