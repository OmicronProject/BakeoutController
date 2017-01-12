package unit.devices;

import kernel.serial_ports.PortCommunicator;

import javax.sound.sampled.Port;
import java.io.*;

/**
 * Created by mkononen on 12/01/17.
 */
public final class DeviceCommunicator implements PortCommunicator {
    private InputStream inputStream;
    private OutputStream outputStream;

    public DeviceCommunicator(
        InputStream inputStream, OutputStream outputStream
    ){
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override public InputStream getInputStream(){
        return this.inputStream;
    }

    @Override public OutputStream getOutputStream(){
        return this.outputStream;
    }

    public void write(String command){
        DeviceWriter writer = new DeviceWriter(command, this);
        Thread writingThread = new Thread(writer);
        writingThread.run();
    }

    public String read(){
        DeviceReader reader = new DeviceReader(this);
        Thread readingThread = new Thread(reader);
        readingThread.start();

        return reader.response;
    }

    private class DeviceReader implements Runnable {
        private final PortCommunicator communicator;
        private String response;

        public DeviceReader(PortCommunicator communicator){
            this.communicator = communicator;
        }

        @Override
        public void run(){
            try{
                response = readInputStream();
            } catch (IOException error){
                handleIOException(error);
            }
        }

        private String readInputStream() throws IOException {
            InputStream stream = communicator.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);

            return buffer.readLine();
        }

        private void handleIOException(IOException error){
            error.printStackTrace();
        }

        public String getResponse(){
            return response;
        }
    }

    private class DeviceWriter implements Runnable {
        private final String command;
        private final PortCommunicator communicator;

        public DeviceWriter(String command, PortCommunicator communicator) {
            this.command = command;
            this.communicator = communicator;
        }

        @Override
        public void run() {
            try {
                OutputStream stream = communicator.getOutputStream();
                stream.write(command.getBytes());
            } catch (IOException error) {
                handleIOException(error);
            }
        }

        private void handleIOException(IOException error) {
            error.printStackTrace();
        }
    }
}
