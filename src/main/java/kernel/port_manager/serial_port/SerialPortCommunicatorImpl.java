package kernel.port_manager.serial_port;

import exceptions.NoCarriageReturnException;
import kernel.java_communications_adapter.CommPort;
import sun.nio.cs.US_ASCII;

import java.io.*;

/**
 * Implements the SerialPortCommunicator to allow for writing data
 */
public class SerialPortCommunicatorImpl implements SerialPortCommunicator {
    private final CommPort serialPort;

    public SerialPortCommunicatorImpl(CommPort serialPort){
        this.serialPort = serialPort;
    }

    @Override public String read() throws IOException {
        InputStream inputStream = this.serialPort.getInputStream();
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader inputBuffer = new BufferedReader(streamReader);

        return inputBuffer.readLine();
    }

    @Override public void write(String commandToWrite) throws IOException {
        checkCommand(commandToWrite);
        OutputStream outputStream = this.serialPort.getOutputStream();

        byte[] dataToWrite = commandToWrite.getBytes(
                US_ASCII.defaultCharset()
        );
        outputStream.write(dataToWrite);

    }

    private void checkCommand(String commandToWrite) throws
            NoCarriageReturnException {
        if (commandToWrite.charAt(commandToWrite.length()) != '\r'){
            throw new NoCarriageReturnException(
                "The desired command does not end in a carriage return " +
                        "character."
            );
        }
    }
}
