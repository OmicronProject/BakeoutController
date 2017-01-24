package kernel.views;

import java.util.List;

/**
 * Describes a reporter for available serial ports
 */
public interface CommPortReporter {
    public List<String> getSerialPortNames();
}
