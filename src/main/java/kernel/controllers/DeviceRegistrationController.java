package kernel.controllers;

import devices.RS232Device;

/**
 * Created by mkononen on 03/02/17.
 */
public interface DeviceRegistrationController {
    void registerRS232Device(RS232Device device);

    <DeviceType extends RS232Device> DeviceType getRS232Device(
            Class<DeviceType> deviceType
    );
}
