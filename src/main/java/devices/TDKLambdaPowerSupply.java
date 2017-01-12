package devices;

import exceptions.ResponseNotOKException;
import kernel.serial_ports.PortCommunicator;

import java.io.IOException;

/**
 * Contains methods for working with the power supply
 */
public class TDKLambdaPowerSupply extends RS232Device implements PowerSupply {
    private final int deviceAddress;

    /**
     *
     * Constructs an instance of the power supply, and places the device
     * into a state where it's capable of accepting remote commands. For the
     * TDK Lambda power supply, this means the "ADR" command must be sent to
     * the device with its matching address. This command must return an
     * "OK" response.
     *
     * @param deviceName The name of the device
     * @param portCommunicator A tool capable of communicating with the device
     * @param deviceAddress An integer representing the address of the
     *                      device on the given port
     * @throws IOException If the device cannot be initialized
     */
    public TDKLambdaPowerSupply(
            String deviceName, PortCommunicator portCommunicator, int
            deviceAddress
    ) throws IOException {
        super(deviceName, portCommunicator);
        this.deviceAddress = deviceAddress;
        this.startDevice();
    }

    @Override public String getName(){
        return deviceName;
    }

    @Override public int getDeviceAddress(){
        return this.deviceAddress;
    }

    @Override public double getVoltage() throws IOException {
        return this.writeWithDoubleResponse(GET_VOLTAGE_COMMAND);
    }

    @Override public void setVoltage(double newVoltage) throws IOException {
        String commandToWrite = String.format(
            PowerSupply.SET_VOLTAGE_COMMAND, newVoltage
        );
        this.writeWithOKResponse(commandToWrite);
    }

    @Override public void reset() throws IOException {
        this.writeWithOKResponse(RESET_COMMAND);
    }

    @Override public double getCurrent() throws IOException {
        return this.writeWithDoubleResponse(GET_CURRENT_COMMAND);
    }

    @Override public void setCurrent(double newCurrent) throws IOException {
        String commandToWrite = String.format(
            PowerSupply.SET_CURRENT_COMMAND, newCurrent
        );

        this.writeWithOKResponse(commandToWrite);
    }

    @Override public void outputOff() throws IOException {
        String commandToWrite = String.format(
            PowerSupply.SET_OUTPUT_COMMAND, OFF
        );

        this.writeWithOKResponse(commandToWrite);
    }

    @Override public void outputOn() throws IOException {
        String command = String.format(
                SET_OUTPUT_COMMAND, ON
        );

        this.writeWithOKResponse(command);
    }

    private void startDevice() throws IOException {
        String commandToWrite = String.format(GET_ADDRESS_COMMAND,
                deviceAddress);

        this.writeWithOKResponse(commandToWrite);
    }

    private double writeWithDoubleResponse(String commandToWrite) throws
            IOException {
        this.write(commandToWrite);
        String response = this.read();

        return Double.parseDouble(response);
    }

    private void writeWithOKResponse(String commandToWrite) throws
            IOException {
        this.write(commandToWrite);
        String response = this.read();

        if (!response.equals(PowerSupply.OK_RESPONSE)){
            throw new ResponseNotOKException("Did not receive response of " +
                    "\"OK\"");
        }
    }
}
