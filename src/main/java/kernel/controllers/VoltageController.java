package kernel.controllers;

/**
 * Contains methods for controlling the TDK Lambda Power supply
 */
public interface VoltageController {
    void setVoltage(Double newVoltage);

    void turnOn();

    void turnOff();
}
