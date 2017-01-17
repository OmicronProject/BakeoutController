package devices;

import kernel.serial_ports.PortCommunicator;

import java.io.*;

/**
 * Base class for all devices using an RS232 serial port
 */
public abstract class RS232Device implements NamedDevice {
    private final PortCommunicator portCommunicator;
    protected final String deviceName;

    /**
     * @param deviceName The name of the device
     * @param portCommunicator Something capable of retrieving an
     * {@link InputStream} and an {@link OutputStream}
     */
    public RS232Device(String deviceName, PortCommunicator portCommunicator){
        this.deviceName = deviceName;
        this.portCommunicator = portCommunicator;
    }

    /**
     * @return The latest message from the device
     * @throws IOException if the device cannot be read
     */
    protected String read() throws IOException {
        InputStream inputStream = this.portCommunicator.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader
                (inputStream);

        BufferedReader inputStreamBuffer = new BufferedReader
                (inputStreamReader);

        return inputStreamBuffer.readLine();
    }

    /**
     * @param commandToWrite The command to write
     * @throws IOException if a valid command cannot be written to the port
     */
    protected void write(String commandToWrite) throws IOException {
        OutputStream outputStream = this.portCommunicator.getOutputStream();
        OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter buffer = new BufferedWriter(streamWriter);

        buffer.write(commandToWrite);
        buffer.flush();
    }
}
