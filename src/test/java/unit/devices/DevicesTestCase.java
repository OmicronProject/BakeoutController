package unit.devices;

import kernel.serial_ports.PortCommunicator;
import org.jmock.Expectations;
import org.junit.Before;
import unit.UnitTestCase;

import java.io.*;

/**
 * Base class for all unit tests of {@link devices}
 */
public abstract class DevicesTestCase extends UnitTestCase {
    protected PortCommunicator communicatorForDevice;
    protected DeviceCommunicator communicatorForTestCase;

    protected PipedInputStream mockInputStream;
    protected PipedOutputStream mockOutputStream;

    protected PipedOutputStream streamForWritingToDevice;
    protected PipedInputStream streamForReadingFromDevice;

    @Before
    public void setUpDevicesTestCase() throws IOException {
        initializeDeviceCommunicator();
        initializeMockStreams();
        initializeTestCaseCommunicator();
        checkExpectations();
    }

    private void initializeDeviceCommunicator(){
        this.communicatorForDevice = this.context.mock(PortCommunicator.class);
    }

    private void initializeMockStreams() throws IOException {
        this.mockInputStream = new PipedInputStream();
        this.mockOutputStream = new PipedOutputStream();

        this.streamForReadingFromDevice = new PipedInputStream(this
                .mockOutputStream);

        this.streamForWritingToDevice = new PipedOutputStream(this
                .mockInputStream);
    }

    private void initializeTestCaseCommunicator(){
        this.communicatorForTestCase = new DeviceCommunicator(
            this.streamForReadingFromDevice, this.streamForWritingToDevice
        );
    }

    private void checkExpectations() throws IOException {
        this.context.checking(new StreamExpectations());
    }

    class StreamExpectations extends Expectations {
        public StreamExpectations() throws IOException {

            oneOf(communicatorForDevice).getInputStream();
            will(returnValue(mockInputStream));

            oneOf(communicatorForDevice).getOutputStream();
            will(returnValue(mockOutputStream));
        }
    }
}
