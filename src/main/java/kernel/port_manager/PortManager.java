package kernel.port_manager;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import kernel.port_manager.serial_port.SerialPort;

import java.util.ArrayList;
/**
 * Wraps static methods in the Java Communications API to allow stubbing
 */
public interface PortManager {

    /**
     * @return The names of all communication ports
     */
    ArrayList<String> getPortNames();

    /**
     * @return A list of serial ports available to the system
     */
    ArrayList<String> getSerialPortNames();

    /**
     * @param portName The name of the port that needs to be retrieved
     * @return A port identifier representing the serial port
     */
    SerialPort getPortByName(String portName) throws NoSuchPortException;
}
