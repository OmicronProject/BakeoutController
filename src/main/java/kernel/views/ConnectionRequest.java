package kernel.views;

/**
 * Created by mkononen on 07/02/17.
 */
public interface ConnectionRequest {
    DeviceListEntry getDeviceListEntry();

    Integer getAddress();

    String getPortName();
}
