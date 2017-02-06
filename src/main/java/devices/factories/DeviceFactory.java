package devices.factories;

import exceptions.DeviceNotCreatedException;
import kernel.serial_ports.SerialPort;

/**
 * Created by mkononen on 06/02/17.
 */
public interface DeviceFactory<DeviceType> {
    DeviceType getDevice() throws DeviceNotCreatedException;

    SerialPort getSerialPort();

    void setSerialPort(SerialPort port);

    Integer getAddress();

    void setAddress(Integer address);
}
