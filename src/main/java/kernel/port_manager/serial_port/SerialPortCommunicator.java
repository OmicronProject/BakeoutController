package kernel.port_manager.serial_port;

import java.io.IOException;

/**
 * Provides a contract for reading and writing to the serial port
 */
public interface SerialPortCommunicator {
    String read() throws IOException;
    void write(String commandToWrite) throws IOException;
}
