package kernel.controllers;

import devices.factories.DeviceFactory;
import kernel.views.DeviceListEntry;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 */
public class ConnectionManager implements DeviceConnector {
    private DeviceListEntry deviceListEntry;
    private String portName;
    private DeviceRegistry deviceRegistry;

    @Override
    public DeviceListEntry getDeviceToConnect(){
        return this.deviceListEntry;
    }

    @Override
    public void setDeviceToConnect(DeviceListEntry entry){
        this.deviceListEntry = entry;
    }

    @Override
    public String getPortName(){
        return this.portName;
    }

    @Override
    public void setPortName(String portName){
        this.portName = portName;
    }

    @Override
    public DeviceRegistry getDeviceRegistry(){
        return this.deviceRegistry;
    }

    @Override
    public void setDeviceRegistry(DeviceRegistry registry){
        this.deviceRegistry = registry;
    }

    @Override
    public Boolean canMakeConnections(){
        return (this.hasEntry() && this.hasPortName() && this.hasRegistry());
    }

    @Override
    public void connect(){

    }

    private DeviceFactory getDeviceFactory(){
        return this.deviceListEntry.getDeviceFactory();
    }

    private void configureDeviceFactory(DeviceFactory factory){
    }

    @NotNull
    @Contract(pure = true)
    private Boolean hasEntry(){
        return this.deviceListEntry != null;
    }

    @NotNull
    @Contract(pure = true)
    private Boolean hasPortName(){
        return this.portName != null;
    }

    @NotNull
    @Contract(pure = true)
    private Boolean hasRegistry(){
        return this.deviceRegistry != null;
    }
}
