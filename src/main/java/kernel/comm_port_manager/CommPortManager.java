package kernel.comm_port_manager;

import java.util.Enumeration;

/**
 * Created by mkononen on 09/12/16.
 */
public interface CommPortManager {
    Enumeration<String> getCommPortNames();
}
