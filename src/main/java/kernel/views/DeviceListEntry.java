package kernel.views;

/**
 * Created by mkononen on 02/02/17.
 */
public interface DeviceListEntry {
    Class getDeviceType();

    @Override String toString();
}
