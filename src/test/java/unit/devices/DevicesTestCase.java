package unit.devices;

import kernel.serial_ports.PortCommunicator;
import org.junit.Before;
import unit.UnitTestCase;

import java.io.*;

/**
 * Base class for all unit tests of {@link devices}
 */
public abstract class DevicesTestCase extends UnitTestCase {
    protected DeviceCommunicator communicatorForDevice;

    @Before
    public void setUpDevicesTestCase() throws IOException {
        initializeDeviceCommunicator();
    }

    private void initializeDeviceCommunicator(){
        this.communicatorForDevice = new DeviceCommunicator();
    }

    protected class DeviceCommunicator implements PortCommunicator {
        InputStream inputStream;
        OutputStream outputStream;

        public DeviceCommunicator(){
            this.inputStream = new ByteArrayInputStream("OK".getBytes());
            this.outputStream = new ByteArrayOutputStream();
        }

        @Override public InputStream getInputStream(){
            return this.inputStream;
        }

        @Override public OutputStream getOutputStream(){
            return this.outputStream;
        }

        public void setReadData(String dataForDeviceToRead){
            this.inputStream = new ByteArrayInputStream(
                dataForDeviceToRead.getBytes()
            );
        }

        public String getReadData(){
            String data = this.outputStream.toString();
            this.outputStream = new ByteArrayOutputStream();
            return data;
        }
    }
}
