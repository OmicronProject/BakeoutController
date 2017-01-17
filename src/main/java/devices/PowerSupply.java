package devices;

import java.io.IOException;

/**
 * Describes all methods that the power supply implements
 */
public interface PowerSupply extends NamedDevice {
    char terminationCharacter = '\r';

    String GET_ADDRESS_COMMAND = "ADR %d\r";

    String GET_VOLTAGE_COMMAND = "PV?\r";

    String SET_VOLTAGE_COMMAND = "PV %.3f\r";

    String GET_CURRENT_COMMAND = "PC?\r";

    String SET_CURRENT_COMMAND = "PC %.3f\r";

    String SET_OUTPUT_COMMAND = "OUT %s\r";

    String RESET_COMMAND = "RST\r";

    String OK_RESPONSE = "OK";

    String OFF = "0";

    String ON = "1";

    void reset() throws IOException;

    Double getVoltage() throws IOException;

    void setVoltage(double newVoltage) throws IOException;

    double getCurrent() throws IOException;

    void setCurrent(double newCurrent) throws IOException;

    int getDeviceAddress();

    void outputOn() throws IOException;

    void outputOff() throws IOException;
}