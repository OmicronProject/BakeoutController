package kernel.port_manager.serial_port;

/**
 * Describes what is configurable by a serial port
 */
public interface PortConfigurationParameters {
    String getPortName();
    int getBaudRate();
    int getDataFormat();
    int getStopBits();
    int getParityBits();
}
