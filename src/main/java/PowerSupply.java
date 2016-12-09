/**
 * Created by mkononen on 09/12/16.
 */
import gnu.io.SerialPort;

import java.io.IOException;

/**
 * Instantiate a power supply
 */
public class PowerSupply {
    private SerialPort serialPort;
    private int baudRate = 9600;
    private int dataBits = SerialPort.DATABITS_8;
    private int stopBits = SerialPort.STOPBITS_1;
    private int parityBits = SerialPort.PARITY_NONE;

    /**
     * Construct an instrument
     * @param serialPort The serial port to which this instrument is
     *                   attached.
     */
    PowerSupply(SerialPort serialPort) {
        this.serialPort = serialPort;
    }


    public void getRequiredPortParameters() {

    }

    private void configurePortDataBitRate() throws IOException {
        int number_of_bits = serialPort.getDataBits();

        if (number_of_bits != SerialPort.DATABITS_8) {
            throw new IOException("Unable to set port");
        }
    }
}
