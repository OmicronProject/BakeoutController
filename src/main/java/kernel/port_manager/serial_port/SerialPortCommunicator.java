package kernel.port_manager.serial_port;

/**
 * Provides a contract for reading and writing to the serial port
 */
public interface SerialPortCommunicator {
    String read();
    void write(String commandToWrite);
}
