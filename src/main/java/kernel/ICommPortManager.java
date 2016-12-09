package kernel;

import java.util.Enumeration;

/**
 * Created by mkononen on 09/12/16.
 */
public interface ICommPortManager {
    Enumeration<String> getCommPortNames();
}
